package moe.crx.roadblock.serialization

import kotlinx.datetime.Instant
import kotlinx.serialization.*
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.StructureKind
import kotlinx.serialization.encoding.AbstractEncoder
import kotlinx.serialization.internal.AbstractPolymorphicSerializer
import kotlinx.serialization.modules.EmptySerializersModule
import kotlinx.serialization.modules.SerializersModule
import java.io.OutputStream
import kotlin.reflect.full.companionObjectInstance

@OptIn(ExperimentalSerializationApi::class)
class RoadblockEncoder(
    private val output: OutputStream,
    private val version: SerializationVersion,
    override val serializersModule: SerializersModule = EmptySerializersModule(),
    private val instantSerialName: String = serializersModule.serializer<Instant>().descriptor.serialName,
    private val byteArraySerialName: String = serializersModule.serializer<ByteArray>().descriptor.serialName,
    private val scratchBuffer: ByteArray = ByteArray(8),
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
        if (serializer.descriptor.kind == StructureKind.OBJECT) {
            throw SerializationException("Objects are not supported.")
        }

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
            // TODO Optimize this?
            val companion = serializer.baseClass.companionObjectInstance as? VariantCompanion<*>
            companion?.let {
                return encodeVariant(it, value)
            }
        }

        return super.encodeSerializableValue(serializer, value)
    }

    @Suppress("UNCHECKED_CAST")
    @OptIn(InternalSerializationApi::class)
    fun <T> encodeVariant(companion: VariantCompanion<*>, value: T) {
        checkNotNull(value)
        // TODO Optimize this?
        val variants = companion.variants(version)
        val valueClass = value::class
        val index = variants.indexOf(valueClass)
        val serializer = valueClass.serializer() as KSerializer<T>
        encodeInt(index)
        encodeSerializableValue(serializer, value)
    }

    fun encodeByteArray(value: ByteArray) {
        encodeInt(value.size)
        output.write(value)
    }

    fun encodeInstant(value: Instant) = encodeLong(value.epochSeconds)

    override fun encodeBoolean(value: Boolean) = output.write(if (value) 1 else 0)
    override fun encodeByte(value: Byte) = output.write(value.toInt() and 0xFF)
    override fun encodeFloat(value: Float) = encodeInt(value.toRawBits())
    override fun encodeDouble(value: Double) = encodeLong(value.toRawBits())
    override fun encodeString(value: String) = encodeByteArray(value.toByteArray(Charsets.UTF_8))

    override fun encodeEnum(enumDescriptor: SerialDescriptor, index: Int) {
        val annotations = currentDescriptor?.getElementAnnotations(elementIndex)
        if (annotations.byteEnum()) {
            encodeByte(index.toByte())
        } else {
            encodeInt(index)
        }
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

    override fun beginStructure(descriptor: SerialDescriptor) =
        RoadblockEncoder(output, version, serializersModule, instantSerialName, byteArraySerialName, scratchBuffer)
}