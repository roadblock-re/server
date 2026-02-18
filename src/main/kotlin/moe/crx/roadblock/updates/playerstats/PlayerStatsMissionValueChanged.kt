package moe.crx.roadblock.updates.playerstats

import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.MissionType
import moe.crx.roadblock.objects.game.MissionValue

class PlayerStatsMissionValueChanged : RObject {

    var mission: MissionType = MissionType.Stunts
    var oldValue: MissionValue = 0
    var newValue: MissionValue = 0

    override fun read(sink: InputSink) {
        mission = sink.readEnum()
        oldValue = sink.readInt()
        newValue = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeEnum(mission)
        sink.writeInt(oldValue)
        sink.writeInt(newValue)
    }
}