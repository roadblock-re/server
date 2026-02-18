package moe.crx.roadblock.objects.quarantine

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject

class QuarantineEvidenceData : RObject {

    var sources: List<RInt> = listOf()
    var mostRecentTimePoint: Instant = now()
    var numberOfOccurrences: Int = 0

    override fun read(sink: InputSink) {
        sources = sink.readList()
        mostRecentTimePoint = sink.readInstant()
        numberOfOccurrences = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeList(sources)
        sink.writeInstant(mostRecentTimePoint)
        sink.writeInt(numberOfOccurrences)
    }
}