package moe.crx.roadblock.objects

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.serializer
import moe.crx.roadblock.game.serialization.Blob
import moe.crx.roadblock.game.serialization.ByteEnum
import net.jpountz.lz4.LZ4Compressor
import net.jpountz.lz4.LZ4Factory
import net.jpountz.lz4.LZ4FastDecompressor

@Serializable(ConfigDataSerializer::class)
data class ConfigData(
    var compression: CompressionType,
    var data: Blob,
)

object ConfigDataSerializer : KSerializer<ConfigData> {

    val decompressor: LZ4FastDecompressor = LZ4Factory.fastestInstance().fastDecompressor()
    val compressor: LZ4Compressor = LZ4Factory.fastestInstance().fastCompressor()

    val compressionTypeSerializer = serializer<CompressionType>()
    val byteArraySerializer = serializer<ByteArray>()

    override val descriptor = buildClassSerialDescriptor(ConfigData::class.simpleName ?: "ConfigData") {
        element<Long>("header")
        element<CompressionType>("compressionType", listOf(ByteEnum()))
        element<ByteArray>("payload")
        element<Long>("decompressedLength")
    }

    override fun deserialize(decoder: Decoder): ConfigData {
        val composite = decoder.beginStructure(descriptor)

        var compressionType = CompressionType.UNKNOWN
        var data = ByteArray(0)
        var decompressedLength = 0L

        loop@ while (true) {
            when (val index = composite.decodeElementIndex(descriptor)) {
                CompositeDecoder.DECODE_DONE -> break@loop

                0 -> {
                    val header = composite.decodeLongElement(descriptor, 0)
                    check(header == 1L) { "Invalid ConfigData header: $header" }
                }

                1 -> compressionType = composite.decodeSerializableElement(descriptor, 1, compressionTypeSerializer)
                2 -> data = composite.decodeSerializableElement(descriptor, 2, byteArraySerializer)
                3 -> decompressedLength = composite.decodeLongElement(descriptor, 3)
                else -> throw SerializationException("Unknown index $index")
            }
        }

        composite.endStructure(descriptor)

        val decompressedData = if (compressionType == CompressionType.LZ4) {
            decompressor.decompress(data, 0, decompressedLength.toInt())
        } else {
            data
        }

        return ConfigData(
            compression = compressionType,
            data = Blob(decompressedData),
        )
    }

    override fun serialize(encoder: Encoder, value: ConfigData) {
        val compressedData = if (value.compression == CompressionType.LZ4) {
            compressor.compress(value.data.bytes)
        } else {
            value.data.bytes
        }

        val composite = encoder.beginStructure(descriptor)

        composite.encodeLongElement(descriptor, 0, 1L)
        composite.encodeSerializableElement(descriptor, 1, compressionTypeSerializer, value.compression)
        composite.encodeSerializableElement(descriptor, 2, byteArraySerializer, compressedData)
        composite.encodeLongElement(descriptor, 3, value.data.bytes.size.toLong())

        composite.endStructure(descriptor)
    }
}