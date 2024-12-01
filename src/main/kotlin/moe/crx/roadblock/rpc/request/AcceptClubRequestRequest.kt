package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.ClubId
import moe.crx.roadblock.objects.game.ClubRequestId
import moe.crx.roadblock.rpc.base.RequestPacket

class AcceptClubRequestRequest : RequestPacket() {

    var clubId: ClubId = ""
    var requestId: ClubRequestId = ""
    var debugSuffix: String = ""

    override fun read(sink: InputSink) {
        super.read(sink)
        clubId = sink.readString()
        requestId = sink.readString()
        debugSuffix = sink.readString()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(clubId)
        sink.writeString(requestId)
        sink.writeString(debugSuffix)
    }
}