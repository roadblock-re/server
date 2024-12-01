package moe.crx.roadblock.objects.models

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.career.CareerChapterState
import moe.crx.roadblock.objects.career.CareerEventState
import moe.crx.roadblock.objects.career.CareerSeasonState

class CareerState : RObject {

    var careerFlags: Int = 0
    var seasons: List<CareerSeasonState> = listOf()
    var events: List<CareerEventState> = listOf()
    var chapters: List<CareerChapterState> = listOf()

    override fun read(sink: InputSink) {
        careerFlags = sink.readInt()
        seasons = sink.readList()
        events = sink.readList()
        chapters = sink.readList()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(careerFlags)
        sink.writeList(seasons)
        sink.writeList(events)
        sink.writeList(chapters)
    }
}