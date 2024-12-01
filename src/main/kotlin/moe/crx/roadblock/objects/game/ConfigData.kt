package moe.crx.roadblock.objects.game

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import net.jpountz.lz4.LZ4Compressor
import net.jpountz.lz4.LZ4Factory
import net.jpountz.lz4.LZ4FastDecompressor

class ConfigData : RObject {
    companion object {
        val decompressor: LZ4FastDecompressor = LZ4Factory.fastestInstance().fastDecompressor()
        val compressor: LZ4Compressor = LZ4Factory.fastestInstance().fastCompressor()
    }

    // 1 == Uncompressed, 2 == LZ4
    var compressionType: Byte = 0
    var data: ByteArray = ByteArray(0)

    override fun read(sink: InputSink) {
        compressionType = sink.readByte()
        val bytes = sink.readByteArray()
        val decompressedLength = sink.readLong()

        data = if (compressionType != 2.toByte()) bytes else {
            decompressor.decompress(bytes, 0, decompressedLength.toInt())
        }
    }

    override fun write(sink: OutputSink) {
        val bytes = if (compressionType != 2.toByte()) data else {
            compressor.compress(data)
        }

        sink.writeByte(compressionType)
        sink.writeByteArray(bytes)
        sink.writeLong(data.size.toLong())
    }
}