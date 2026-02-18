package moe.crx.roadblock.objects.championship

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject

class ChampionshipEvidenceData : RObject {

    var sources: List<RInt> = listOf()
    var count: Int = 0
    var timestamp: Instant = now()

    override fun read(sink: InputSink) {
        sources = sink.readList()
        count = sink.readInt()
        timestamp = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeList(sources)
        sink.writeInt(count)
        sink.writeInstant(timestamp)
    }

}
