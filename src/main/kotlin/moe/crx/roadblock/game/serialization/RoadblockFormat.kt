package moe.crx.roadblock.game.serialization

import kotlinx.datetime.Instant
import kotlinx.serialization.*
import kotlinx.serialization.modules.EmptySerializersModule
import kotlinx.serialization.modules.SerializersModule
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream

@OptIn(ExperimentalSerializationApi::class)
class RoadblockFormat(
    val version: SerializationVersion,
    override val serializersModule: SerializersModule = EmptySerializersModule()
) : BinaryFormat {

    private val instantSerialName: String = serializersModule.serializer<Instant>().descriptor.serialName
    private val byteArraySerialName: String = serializersModule.serializer<ByteArray>().descriptor.serialName

    override fun <T> encodeToByteArray(
        serializer: SerializationStrategy<T>,
        value: T
    ): ByteArray {
        val output = ByteArrayOutputStream()
        RoadblockEncoder(
            output,
            version,
            serializersModule,
            instantSerialName,
            byteArraySerialName,
        ).encodeSerializableValue(serializer, value)
        return output.toByteArray()
    }

    override fun <T> decodeFromByteArray(
        deserializer: DeserializationStrategy<T>,
        bytes: ByteArray
    ): T {
        val input = ByteArrayInputStream(bytes)
        val value = RoadblockDecoder(
            input,
            version,
            serializersModule,
            instantSerialName,
            byteArraySerialName,
        ).decodeSerializableValue(deserializer)
        return value
    }
}