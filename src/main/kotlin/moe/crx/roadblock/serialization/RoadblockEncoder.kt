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

    val byteArraySerializer = serializersModule.serializer<ByteArray>()
    val instantSerializer = serializersModule.serializer<Instant>()

    override fun <T> encodeSerializableValue(serializer: SerializationStrategy<T>, value: T) =
        when (serializer.descriptor) {
            byteArraySerializer.descriptor -> encodeByteArray(value as ByteArray)
            instantSerializer.descriptor -> encodeInstant(value as Instant)
            else -> super.encodeSerializableValue(serializer, value)
        }

    fun encodeByteArray(value: ByteArray) {
        encodeInt(value.size)
        output.write(value)
    }

    fun encodeInstant(value: Instant) = encodeLong(value.epochSeconds)

    @ExperimentalSerializationApi
    override fun encodeNotNullMark() = encodeBoolean(true)

    override fun encodeNull() = encodeBoolean(false)

    override fun encodeBoolean(value: Boolean) {
        output.write(if (value) 1 else 0)
    }

    override fun encodeByte(value: Byte) {
        output.write(value.toInt() and 0xFF)
    }

    override fun encodeShort(value: Short) {
        output.write(value.toInt() and 0xFF)
        output.write(value.toInt() ushr 8 and 0xFF)
    }

    override fun encodeInt(value: Int) {
        output.write(value and 0xFF)
        output.write(value ushr 8 and 0xFF)
        output.write(value ushr 16 and 0xFF)
        output.write(value ushr 24 and 0xFF)
    }

    override fun encodeLong(value: Long) {
        output.write(value.toInt() and 0xFF)
        output.write((value ushr 8).toInt() and 0xFF)
        output.write((value ushr 16).toInt() and 0xFF)
        output.write((value ushr 24).toInt() and 0xFF)
        output.write((value ushr 32).toInt() and 0xFF)
        output.write((value ushr 40).toInt() and 0xFF)
        output.write((value ushr 48).toInt() and 0xFF)
        output.write((value ushr 56).toInt() and 0xFF)
    }

    override fun encodeFloat(value: Float) = encodeInt(value.toRawBits())

    override fun encodeDouble(value: Double) = encodeLong(value.toRawBits())

    override fun encodeString(value: String) = encodeByteArray(value.toByteArray())

    override fun encodeEnum(enumDescriptor: SerialDescriptor, index: Int) = encodeInt(index)
}