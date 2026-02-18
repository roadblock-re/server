package moe.crx.roadblock.game.serialization

import kotlinx.datetime.Instant
import kotlinx.serialization.*
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.AbstractEncoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.internal.AbstractPolymorphicSerializer
import kotlinx.serialization.modules.EmptySerializersModule
import kotlinx.serialization.modules.SerializersModule
import moe.crx.roadblock.game.serialization.VariantCompanionRegistry.getVariantCompanion
import moe.crx.roadblock.game.serialization.VersionedMappingRegistry.getMapping
import java.io.OutputStream

@OptIn(ExperimentalSerializationApi::class)
class RoadblockEncoder(
    private val output: OutputStream,
    private val version: SerializationVersion,
    override val serializersModule: SerializersModule = EmptySerializersModule(),
    private val instantSerialName: String = serializersModule.serializer<Instant>().descriptor.serialName,
    private val byteArraySerialName: String = serializersModule.serializer<ByteArray>().descriptor.serialName,
    private val scratchBuffer: ByteArray = ByteArray(8),
    private val elementAnnotations: List<Annotation>? = null,
) : AbstractEncoder() {

    private var elementIndex = -1
    private var currentDescriptor: SerialDescriptor? = null

    override fun encodeElement(descriptor: SerialDescriptor, index: Int): Boolean {
        currentDescriptor = descriptor

        elementIndex = index
        val annotations = descriptor.getElementAnnotations(elementIndex)
        return annotations.isPresentIn(version)
    }

    @OptIn(InternalSerializationApi::class)
    override fun <T> encodeSerializableValue(serializer: SerializationStrategy<T>, value: T) {
        if (serializer.descriptor.isNullable) {
            return super.encodeSerializableValue(serializer, value)
        }

        if (serializer.descriptor.serialName == instantSerialName) {
            return encodeInstant(value as Instant)
        }

        if (serializer.descriptor.serialName == byteArraySerialName) {
            return encodeByteArray(value as ByteArray)
        }

        if (serializer is AbstractPolymorphicSerializer<*>) {
            serializer.baseClass.getVariantCompanion()?.let {
                return encodeVariant(it, value as Any)
            }
        }

        return super.encodeSerializableValue(serializer, value)
    }

    @Suppress("UNCHECKED_CAST")
    @OptIn(InternalSerializationApi::class)
    fun <T : Any> encodeVariant(companion: VariantCompanion<*>, value: T) {
        val mapping = companion.getMapping(version)
        val index = mapping.classToIndex[value::class]
            ?: throw SerializationException("${value::class} not in protocol version $version")

        encodeInt(index)
        val serializer = mapping.indexToSerializer[index] as KSerializer<T>
        encodeSerializableValue(serializer, value)
    }

    fun encodeByteArray(value: ByteArray) {
        encodeInt(value.size)
        output.write(value)
    }

    fun encodeInstant(value: Instant) = encodeLong(value.epochSeconds)

    override fun encodeBoolean(value: Boolean) = encodeByte(if (value) 1 else 0)
    override fun encodeFloat(value: Float) = encodeInt(value.toRawBits())
    override fun encodeDouble(value: Double) = encodeLong(value.toRawBits())
    override fun encodeString(value: String) = encodeByteArray(value.toByteArray(Charsets.UTF_8))

    override fun encodeEnum(enumDescriptor: SerialDescriptor, index: Int) {
        val annotations = { currentDescriptor?.getElementAnnotations(elementIndex) }
        val classAnnotations = enumDescriptor.annotations

        if (classAnnotations.isByteEnum() || elementAnnotations.isByteEnum() || annotations().isByteEnum()) {
            encodeByte(index.toByte())
        } else {
            encodeInt(index)
        }
    }

    override fun encodeByte(value: Byte) {
        val value = value.toInt()
        scratchBuffer[0] = (value and 0xFF).toByte()
        output.write(scratchBuffer, 0, 1)
    }

    override fun encodeShort(value: Short) {
        val value = value.toInt()
        scratchBuffer[0] = (value and 0xFF).toByte()
        scratchBuffer[1] = ((value ushr 8) and 0xFF).toByte()
        output.write(scratchBuffer, 0, 2)
    }

    override fun encodeInt(value: Int) {
        scratchBuffer[0] = (value and 0xFF).toByte()
        scratchBuffer[1] = ((value ushr 8) and 0xFF).toByte()
        scratchBuffer[2] = ((value ushr 16) and 0xFF).toByte()
        scratchBuffer[3] = ((value ushr 24) and 0xFF).toByte()
        output.write(scratchBuffer, 0, 4)
    }

    override fun encodeLong(value: Long) {
        scratchBuffer[0] = (value and 0xFF).toByte()
        scratchBuffer[1] = ((value ushr 8) and 0xFF).toByte()
        scratchBuffer[2] = ((value ushr 16) and 0xFF).toByte()
        scratchBuffer[3] = ((value ushr 24) and 0xFF).toByte()
        scratchBuffer[4] = ((value ushr 32) and 0xFF).toByte()
        scratchBuffer[5] = ((value ushr 40) and 0xFF).toByte()
        scratchBuffer[6] = ((value ushr 48) and 0xFF).toByte()
        scratchBuffer[7] = ((value ushr 56) and 0xFF).toByte()
        output.write(scratchBuffer, 0, 8)
    }

    @ExperimentalSerializationApi
    override fun encodeNotNullMark() = encodeBoolean(true)
    override fun encodeNull() = encodeBoolean(false)

    override fun beginCollection(descriptor: SerialDescriptor, collectionSize: Int) =
        encodeInt(collectionSize).let { beginStructure(descriptor) }

    override fun beginStructure(descriptor: SerialDescriptor): CompositeEncoder {
        val elementAnnotations = currentDescriptor?.getElementAnnotations(elementIndex)

        return RoadblockEncoder(
            output,
            version,
            serializersModule,
            instantSerialName,
            byteArraySerialName,
            scratchBuffer,
            elementAnnotations,
        )
    }
}