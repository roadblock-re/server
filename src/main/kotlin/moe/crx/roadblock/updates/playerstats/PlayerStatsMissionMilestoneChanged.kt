package moe.crx.roadblock.updates.playerstats

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.MissionMilestone
import moe.crx.roadblock.objects.game.MissionType

class PlayerStatsMissionMilestoneChanged : RObject {

    var mission: MissionType = MissionType.Stunts
    var oldMilestone: MissionMilestone = 0
    var newMilestone: MissionMilestone = 0

    override fun read(sink: InputSink) {
        mission = sink.readEnum()
        oldMilestone = sink.readShort()
        newMilestone = sink.readShort()
    }

    override fun write(sink: OutputSink) {
        sink.writeEnum(mission)
        sink.writeShort(oldMilestone)
        sink.writeShort(newMilestone)
    }
}