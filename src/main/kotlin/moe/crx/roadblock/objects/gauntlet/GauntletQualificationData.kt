package moe.crx.roadblock.objects.gauntlet

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class GauntletQualificationData : RObject {

    var qualificationStats: List<GauntletRaceStats> = listOf()
    var timestamp: Instant = now()

    override fun read(sink: InputSink) {
        qualificationStats = sink.readList()
        timestamp = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeList(qualificationStats)
        sink.writeInstant(timestamp)
    }

}
