package moe.crx.roadblock.rpc.base

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink

open class RequestPacket() : Packet(PacketDirection.REQUEST) {

    var sequence: Int = 0
    var fedId: String = ""
    var type: Short = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        sequence = sink.readInt()
        fedId = sink.readString()
        type = if (sink newer "24.0.0") {
            sink.readShort()
        } else {
            sink.readByte().toShort()
        }
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(sequence)
        sink.writeString(fedId)
        if (sink newer "24.0.0") {
            sink.writeShort(type)
        } else {
            sink.writeByte(type.toByte())
        }
    }
}