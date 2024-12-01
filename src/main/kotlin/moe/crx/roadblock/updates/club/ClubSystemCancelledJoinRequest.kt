package moe.crx.roadblock.updates.club

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CancelJoinRequestReason
import moe.crx.roadblock.objects.game.ClubRequestId

class ClubSystemCancelledJoinRequest : RObject {

    var id: ClubRequestId = ""
    var reason: CancelJoinRequestReason = CancelJoinRequestReason.User
    var clubName: String = ""

    override fun read(sink: InputSink) {
        id = sink.readString()
        reason = sink.readEnum()
        clubName = sink.readString()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(id)
        sink.writeEnum(reason)
        sink.writeString(clubName)
    }
}