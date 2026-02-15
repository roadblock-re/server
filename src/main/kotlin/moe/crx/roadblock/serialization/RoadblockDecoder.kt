package moe.crx.roadblock.serialization

import kotlinx.datetime.Instant
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.AbstractDecoder
import kotlinx.serialization.encoding.CompositeDecoder.Companion.DECODE_DONE
import kotlinx.serialization.modules.EmptySerializersModule
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.serializer
import java.io.InputStream

@OptIn(ExperimentalSerializationApi::class)
class RoadblockDecoder(
    val input: InputStream,
    override val serializersModule: SerializersModule = EmptySerializersModule()
) : AbstractDecoder() {

    private var elementIndex = 0

    private var byteEnumFlag = false

    override fun decodeElementIndex(descriptor: SerialDescriptor): Int {
        val index = if (elementIndex == descriptor.elementsCount) DECODE_DONE else elementIndex++

        val annotations = descriptor.getElementAnnotations(index)

        byteEnumFlag = annotations.any { it is ByteEnum }

        return index
    }

    private val byteArrayDescriptor = serializersModule.serializer<ByteArray>().descriptor
    private val instantDescriptor = serializersModule.serializer<Instant>().descriptor

    @Suppress("UNCHECKED_CAST")
    override fun <T> decodeSerializableValue(deserializer: DeserializationStrategy<T>) =
        when (deserializer.descriptor) {
            byteArrayDescriptor -> decodeByteArray() as T
            instantDescriptor -> decodeInstant() as T
            else -> super.decodeSerializableValue(deserializer)
        }

    fun decodeByteArray(): ByteArray {
        val size = decodeInt()
        return input.readNBytes(size)
    }

    fun decodeInstant() = Instant.fromEpochSeconds(decodeLong(), 0)

    private fun readBytesOrThrow(count: Int) {
        val read = input.readNBytes(scratchBuffer, 0, count)
        if (read < count) throw SerializationException("Required $count bytes, but only got $read")
    }

    override fun decodeBoolean() = readBytesOrThrow(1).let { scratchBuffer[0] != 0.toByte() }
    override fun decodeByte() = readBytesOrThrow(1).let { scratchBuffer[0] }
    override fun decodeFloat() = Float.fromBits(decodeInt())
    override fun decodeDouble() = Double.fromBits(decodeLong())
    override fun decodeString() = decodeByteArray().toString(Charsets.UTF_8)

    override fun decodeEnum(enumDescriptor: SerialDescriptor): Int {
        return if (byteEnumFlag) {
            decodeByte().toInt() and 0xFF
        } else {
            decodeInt()
        }
    }

    private val scratchBuffer = ByteArray(8)

    override fun decodeShort(): Short {
        readBytesOrThrow(2)
        val ch1 = (scratchBuffer[0].toInt() and 0xFF)
        val ch2 = (scratchBuffer[1].toInt() and 0xFF) shl 8
        return (ch1 or ch2).toShort()
    }

    override fun decodeInt(): Int {
        readBytesOrThrow(4)
        val ch1 = (scratchBuffer[0].toInt() and 0xFF)
        val ch2 = (scratchBuffer[1].toInt() and 0xFF) shl 8
        val ch3 = (scratchBuffer[2].toInt() and 0xFF) shl 16
        val ch4 = (scratchBuffer[3].toInt() and 0xFF) shl 24
        return ch1 or ch2 or ch3 or ch4
    }

    override fun decodeLong(): Long {
        readBytesOrThrow(8)
        val ch1 = (scratchBuffer[0].toLong() and 0xFF)
        val ch2 = (scratchBuffer[1].toLong() and 0xFF) shl 8
        val ch3 = (scratchBuffer[2].toLong() and 0xFF) shl 16
        val ch4 = (scratchBuffer[3].toLong() and 0xFF) shl 24
        val ch5 = (scratchBuffer[4].toLong() and 0xFF) shl 32
        val ch6 = (scratchBuffer[5].toLong() and 0xFF) shl 40
        val ch7 = (scratchBuffer[6].toLong() and 0xFF) shl 48
        val ch8 = (scratchBuffer[7].toLong() and 0xFF) shl 56
        return ch1 or ch2 or ch3 or ch4 or ch5 or ch6 or ch7 or ch8
    }

    override fun decodeNotNullMark() = decodeBoolean()
    override fun decodeNull() = null
}