package moe.crx.roadblock.rpc.base

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink

open class RequestPacket() : Packet(PacketDirection.REQUEST) {

    var sequence: Int = 0
    var fedId: String = ""
    var type: Byte = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        sequence = sink.readInt()
        fedId = sink.readString()
        type = sink.readByte()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(sequence)
        sink.writeString(fedId)
        sink.writeByte(type)
    }
}