package moe.crx.roadblock.updates.career

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.Flags
import moe.crx.roadblock.objects.game.SeasonId

class CareerSeasonFlagsChanged : RObject {

    var seasonId: SeasonId = 0
    var oldFlags: Flags = 0
    var newFlags: Flags = 0

    override fun read(sink: InputSink) {
        seasonId = sink.readInt()
        oldFlags = sink.readInt()
        newFlags = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(seasonId)
        sink.writeInt(oldFlags)
        sink.writeInt(newFlags)
    }
}