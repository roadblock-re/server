package moe.crx.roadblock.updates.gacha

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class GachaSystemRetentionBoxReadyTimeChanged : RObject {

    var oldTimePoint: Instant = now()
    var newTimePoint: Instant = now()

    override fun read(sink: InputSink) {
        oldTimePoint = sink.readInstant()
        newTimePoint = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeInstant(oldTimePoint)
        sink.writeInstant(newTimePoint)
    }
}