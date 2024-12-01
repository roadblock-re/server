package moe.crx.roadblock.rpc.base

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

abstract class Packet(private val packetDirection: PacketDirection?) : RObject {

    var direction: Byte = packetDirection?.byteValue ?: 0
        private set

    override fun read(sink: InputSink) {
        direction = sink.readByte()
        packetDirection?.let { check(direction == it.byteValue) }
    }

    override fun write(sink: OutputSink) {
        sink.writeByte(direction)
    }
}