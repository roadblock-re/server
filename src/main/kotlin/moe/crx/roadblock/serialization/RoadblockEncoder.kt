package moe.crx.roadblock.serialization

import kotlinx.datetime.Instant
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerializationStrategy
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.AbstractEncoder
import kotlinx.serialization.internal.AbstractPolymorphicSerializer
import kotlinx.serialization.modules.EmptySerializersModule
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.serializer
import java.io.OutputStream

@OptIn(ExperimentalSerializationApi::class)
class RoadblockEncoder(
    private val output: OutputStream,
    private val version: SerializationVersion,
    override val serializersModule: SerializersModule = EmptySerializersModule()
) : AbstractEncoder() {

    companion object {
        private val byteArrayDescriptor = EmptySerializersModule().serializer<ByteArray>().descriptor.serialName
        private val instantDescriptor = EmptySerializersModule().serializer<Instant>().descriptor.serialName
    }

    private var elementIndex = -1
    private var currentDescriptor: SerialDescriptor? = null

    override fun encodeElement(descriptor: SerialDescriptor, index: Int): Boolean {
        currentDescriptor = descriptor

        elementIndex = index
        val annotations = descriptor.getElementAnnotations(elementIndex)
        return annotations.isPresentIn(version)
    }

    @Suppress("UNCHECKED_CAST")
    @OptIn(InternalSerializationApi::class)
    override fun <T> encodeSerializableValue(serializer: SerializationStrategy<T>, value: T) {
        val effectiveSerializer = if (serializer is AbstractPolymorphicSerializer<*>) {
            val custom = serializersModule.getContextual(serializer.baseClass)
            (custom as? SerializationStrategy<T>) ?: serializer
        } else {
            serializer
        }

        when (effectiveSerializer.descriptor.serialName) {
            byteArrayDescriptor -> encodeByteArray(value as ByteArray)
            instantDescriptor -> encodeInstant(value as Instant)
            else -> super.encodeSerializableValue(effectiveSerializer, value)
        }
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

    private val scratchBuffer = ByteArray(8)

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
        encodeInt(collectionSize).let { RoadblockEncoder(output, version, serializersModule) }

    override fun beginStructure(descriptor: SerialDescriptor) =
        RoadblockEncoder(output, version, serializersModule)
}