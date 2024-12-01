package moe.crx.roadblock.objects.game

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject

class RaceStats : RObject {

    var position: Byte = 0
    var intStats: List<RInt> = listOf()
    var timeStats: List<RInt> = listOf()
    var playModeStats: PlayModeStats? = null
    var playModeType: RInt? = RInt()

    override fun read(sink: InputSink) {
        position = sink.readByte()
        intStats = sink.readList()
        timeStats = sink.readList()
        playModeStats = sink.readOptional()
        playModeType = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeByte(position)
        sink.writeList(intStats)
        sink.writeList(timeStats)
        sink.writeOptional(playModeStats)
        sink.writeOptional(playModeType)
    }
}