package moe.crx.roadblock.updates.clubwars

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class ClubWarsMarketNextRefreshTimeChanged : RObject {

    var newTimePoint: Instant = now()

    override fun read(sink: InputSink) {
        newTimePoint = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeInstant(newTimePoint)
    }
}