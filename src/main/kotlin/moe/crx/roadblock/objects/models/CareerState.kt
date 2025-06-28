package moe.crx.roadblock.objects.models

import moe.crx.roadblock.io.MapIO.readMap
import moe.crx.roadblock.io.MapIO.writeMap
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.career.CareerChapterState
import moe.crx.roadblock.objects.career.CareerEventState
import moe.crx.roadblock.objects.career.CareerSeasonState
import moe.crx.roadblock.objects.game.Flags

class CareerState : RObject {

    var careerFlags: Flags = 0
    var seasons: Map<RInt, CareerSeasonState> = mapOf()
    var events: Map<RInt, CareerEventState> = mapOf()
    var chapters: Map<RInt, CareerChapterState> = mapOf()

    override fun read(sink: InputSink) {
        careerFlags = sink.readInt()
        seasons = sink.readMap()
        events = sink.readMap()
        chapters = sink.readMap()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(careerFlags)
        sink.writeMap(seasons)
        sink.writeMap(events)
        sink.writeMap(chapters)
    }
}