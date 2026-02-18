package moe.crx.roadblock.objects.models

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class VaultEventExtendedData : RObject {

    var startTimepoint: Instant = now()
    var durationInMinutes: Int = 0
    var extendCount: Int = 0

    override fun read(sink: InputSink) {
        startTimepoint = sink.readInstant()
        durationInMinutes = sink.readInt()
        extendCount = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeInstant(startTimepoint)
        sink.writeInt(durationInMinutes)
        sink.writeInt(extendCount)
    }

}
