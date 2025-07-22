package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.rpc.base.RequestPacket

class GetClubInvitationsRequest : RequestPacket() {

    var unknown4: Int = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        unknown4 = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(unknown4)
    }
}