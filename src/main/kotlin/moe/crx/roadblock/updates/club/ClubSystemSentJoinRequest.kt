package moe.crx.roadblock.updates.club

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.ClubId
import moe.crx.roadblock.objects.game.ClubRequestId

class ClubSystemSentJoinRequest : RObject {

    var requestId: ClubRequestId = ""
    var clubId: ClubId = ""
    var clubName: String = ""

    override fun read(sink: InputSink) {
        requestId = sink.readString()
        clubId = sink.readString()
        clubName = sink.readString()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(requestId)
        sink.writeString(clubId)
        sink.writeString(clubName)
    }
}