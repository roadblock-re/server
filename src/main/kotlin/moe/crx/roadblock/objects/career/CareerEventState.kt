package moe.crx.roadblock.objects.career

import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.ProgressState

class CareerEventState : RObject {

    var state: ProgressState = ProgressState.Locked
    var obtainedFlags: List<RInt> = listOf()
    var satelliteRewardState: RInt? = RInt()

    override fun read(sink: InputSink) {
        state = sink.readEnum()
        obtainedFlags = sink.readList()
        satelliteRewardState = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeEnum(state)
        sink.writeList(obtainedFlags)
        sink.writeOptional(satelliteRewardState)
    }
}