package moe.crx.roadblock.objects.uber

import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.UberMissionId

class UberPoolMissionId : RObject {

    var poolType: UberPoolType = UberPoolType.Easy
    var missionId: UberMissionId = 0

    override fun read(sink: InputSink) {
        poolType = sink.readEnum()
        missionId = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeEnum(poolType)
        sink.writeInt(missionId)
    }
}