package moe.crx.roadblock.serialization

import kotlinx.datetime.Instant
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.ExperimentalSerializationApi
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

    override fun decodeElementIndex(descriptor: SerialDescriptor) =
        if (elementIndex == descriptor.elementsCount) DECODE_DONE else elementIndex++

    val byteArraySerializer = serializersModule.serializer<ByteArray>()
    val instantSerializer = serializersModule.serializer<Instant>()

    @Suppress("UNCHECKED_CAST")
    override fun <T> decodeSerializableValue(deserializer: DeserializationStrategy<T>) =
        when (deserializer.descriptor) {
            byteArraySerializer.descriptor -> decodeByteArray() as T
            instantSerializer -> decodeInstant() as T
            else -> super.decodeSerializableValue(deserializer)
        }

    fun decodeByteArray(): ByteArray {
        val size = decodeInt()
        return input.readNBytes(size)
    }

    fun decodeInstant() = Instant.fromEpochSeconds(decodeLong(), 0)

    override fun decodeNotNullMark() = decodeBoolean()

    override fun decodeNull() = null

    override fun decodeBoolean() = input.read() > 0

    override fun decodeByte() = input.read().toByte()

    override fun decodeShort(): Short {
        val ch1 = input.read()
        val ch2 = input.read() shl 8
        return (ch1 or ch2).toShort()
    }

    override fun decodeInt(): Int {
        val ch1 = input.read()
        val ch2 = input.read() shl 8
        val ch3 = input.read() shl 16
        val ch4 = input.read() shl 24
        return ch1 or ch2 or ch3 or ch4
    }

    override fun decodeLong(): Long {
        val ch1 = input.read().toLong()
        val ch2 = input.read().toLong() shl 8
        val ch3 = input.read().toLong() shl 16
        val ch4 = input.read().toLong() shl 24
        val ch5 = input.read().toLong() shl 32
        val ch6 = input.read().toLong() shl 40
        val ch7 = input.read().toLong() shl 48
        val ch8 = input.read().toLong() shl 56
        return ch1 or ch2 or ch3 or ch4 or ch5 or ch6 or ch7 or ch8
    }

    override fun decodeFloat() = Float.fromBits(decodeInt())

    override fun decodeDouble() = Double.fromBits(decodeLong())

    override fun decodeString() = decodeByteArray().toString()

    override fun decodeEnum(enumDescriptor: SerialDescriptor) = decodeInt()
}