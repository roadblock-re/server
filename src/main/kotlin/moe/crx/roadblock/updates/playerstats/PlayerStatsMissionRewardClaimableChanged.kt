package moe.crx.roadblock.updates.playerstats

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.MissionType

class PlayerStatsMissionRewardClaimableChanged : RObject {

    var mission: MissionType = MissionType.Stunts
    var claimable: Boolean = false

    override fun read(sink: InputSink) {
        mission = sink.readEnum()
        claimable = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeEnum(mission)
        sink.writeBoolean(claimable)
    }
}