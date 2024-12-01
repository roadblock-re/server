package moe.crx.roadblock.rpc.base

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink

abstract class SpecialPacket(private val packetType: PacketSpecialType?) : Packet(PacketDirection.SPECIAL) {

    var type: Byte = packetType?.byteValue ?: 0
        private set

    override fun read(sink: InputSink) {
        super.read(sink)
        type = sink.readByte()
        packetType?.let { check(type == it.byteValue) }
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeByte(type)
    }
}