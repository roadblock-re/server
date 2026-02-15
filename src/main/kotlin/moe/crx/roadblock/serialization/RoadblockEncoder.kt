package moe.crx.roadblock.serialization

import kotlinx.datetime.Instant
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerializationStrategy
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.AbstractEncoder
import kotlinx.serialization.modules.EmptySerializersModule
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.serializer
import java.io.OutputStream

@OptIn(ExperimentalSerializationApi::class)
class RoadblockEncoder(
    val output: OutputStream,
    override val serializersModule: SerializersModule = EmptySerializersModule()
) : AbstractEncoder() {

    private var byteEnumFlag = false

    override fun encodeElement(descriptor: SerialDescriptor, index: Int): Boolean {
        val annotations = descriptor.getElementAnnotations(index)

        byteEnumFlag = annotations.any { it is ByteEnum }

        return true
    }

    private val byteArrayDescriptor = serializersModule.serializer<ByteArray>().descriptor
    private val instantDescriptor = serializersModule.serializer<Instant>().descriptor

    override fun <T> encodeSerializableValue(serializer: SerializationStrategy<T>, value: T) =
        when (serializer.descriptor) {
            byteArrayDescriptor -> encodeByteArray(value as ByteArray)
            instantDescriptor -> encodeInstant(value as Instant)
            else -> super.encodeSerializableValue(serializer, value)
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
        if (byteEnumFlag) {
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
}