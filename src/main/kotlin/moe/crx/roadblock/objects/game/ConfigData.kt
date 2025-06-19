package moe.crx.roadblock.objects.game

import moe.crx.roadblock.io.EnumIO.readEnum8
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.EnumIO.writeEnum8
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

    var compressionType: CompressionType = CompressionType.UNKNOWN
    var data: ByteArray = ByteArray(0)

    override fun read(sink: InputSink) {
        val one = sink.readLong()
        check(one == 1L)

        compressionType = sink.readEnum8()
        val bytes = sink.readByteArray()
        val decompressedLength = sink.readLong()

        data = if (compressionType != CompressionType.LZ4) bytes else {
            decompressor.decompress(bytes, 0, decompressedLength.toInt())
        }
    }

    override fun write(sink: OutputSink) {
        sink.writeLong(1)

        val bytes = if (compressionType != CompressionType.LZ4) data else {
            compressor.compress(data)
        }

        sink.writeEnum8(compressionType)
        sink.writeByteArray(bytes)
        sink.writeLong(data.size.toLong())
    }
}