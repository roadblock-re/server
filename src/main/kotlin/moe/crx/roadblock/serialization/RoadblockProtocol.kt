package moe.crx.roadblock.serialization

import kotlinx.serialization.BinaryFormat
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerializationStrategy
import kotlinx.serialization.modules.EmptySerializersModule
import kotlinx.serialization.modules.SerializersModule
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream

class RoadblockProtocol(
    val version: SerializationVersion,
    override val serializersModule: SerializersModule = EmptySerializersModule()
) : BinaryFormat {

    override fun <T> encodeToByteArray(
        serializer: SerializationStrategy<T>,
        value: T
    ): ByteArray {
        val output = ByteArrayOutputStream()
        RoadblockEncoder(output, serializersModule).encodeSerializableValue(serializer, value)
        return output.toByteArray()
    }

    override fun <T> decodeFromByteArray(
        deserializer: DeserializationStrategy<T>,
        bytes: ByteArray
    ): T {
        val input = ByteArrayInputStream(bytes)
        return RoadblockDecoder(input, serializersModule).decodeSerializableValue(deserializer)
    }
}