package moe.crx.roadblock.objects.game

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject

class QuarantineData : RObject {

    var evidences: List<QuarantineEvidence> = listOf()
    var honeyPots: List<RInt> = listOf()

    override fun read(sink: InputSink) {
        evidences = sink.readList()
        honeyPots = sink.readList()
    }

    override fun write(sink: OutputSink) {
        sink.writeList(evidences)
        sink.writeList(honeyPots)
    }
}