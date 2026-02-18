package moe.crx.roadblock.objects.goldenchest

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject

class GoldenChestEventState : RObject {

    var startDate: Instant = now()
    var optLastChestIndexObtained: RInt? = null

    override fun read(sink: InputSink) {
        startDate = sink.readInstant()
        optLastChestIndexObtained = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeInstant(startDate)
        sink.writeOptional(optLastChestIndexObtained)
    }
}