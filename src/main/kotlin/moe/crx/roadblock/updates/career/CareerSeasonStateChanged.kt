package moe.crx.roadblock.updates.career

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.ProgressState
import moe.crx.roadblock.objects.game.SeasonId

class CareerSeasonStateChanged : RObject {

    var seasonId: SeasonId = 0
    var oldState: ProgressState = ProgressState.Locked
    var newState: ProgressState = ProgressState.Locked

    override fun read(sink: InputSink) {
        seasonId = sink.readInt()
        oldState = sink.readEnum()
        newState = sink.readEnum()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(seasonId)
        sink.writeEnum(oldState)
        sink.writeEnum(newState)
    }
}