package moe.crx.roadblock.updates.club

import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.ClubId
import moe.crx.roadblock.objects.game.LeaveClubReason

class ClubSystemLeftClub : RObject {

    var id: ClubId = ""
    var reason: LeaveClubReason = LeaveClubReason.User

    override fun read(sink: InputSink) {
        id = sink.readString()
        reason = sink.readEnum()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(id)
        sink.writeEnum(reason)
    }
}