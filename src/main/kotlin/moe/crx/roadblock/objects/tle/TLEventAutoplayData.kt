package moe.crx.roadblock.objects.tle

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RByte
import moe.crx.roadblock.objects.base.RObject

class TLEventAutoplayData : RObject {

    var finishTimepoint: Instant = now()
    var calculatedRewardIndices: List<RByte> = listOf()

    override fun read(sink: InputSink) {
        finishTimepoint = sink.readInstant()
        calculatedRewardIndices = sink.readList()
    }

    override fun write(sink: OutputSink) {
        sink.writeInstant(finishTimepoint)
        sink.writeList(calculatedRewardIndices)
    }
}