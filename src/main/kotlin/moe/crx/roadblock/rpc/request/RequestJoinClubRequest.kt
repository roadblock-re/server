package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.ClubId
import moe.crx.roadblock.rpc.base.RequestPacket

class RequestJoinClubRequest : RequestPacket() {

    var clubId: ClubId = ""
    var clubName: String = ""
    var debugSuffix: String = ""

    override fun read(sink: InputSink) {
        super.read(sink)
        clubId = sink.readString()
        clubName = sink.readString()
        debugSuffix = sink.readString()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(clubId)
        sink.writeString(clubName)
        sink.writeString(debugSuffix)
    }
}