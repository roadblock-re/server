package moe.crx.roadblock.objects.gauntlet

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.MapIO.readMap
import moe.crx.roadblock.io.MapIO.writeMap
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject

class GauntletMarketState : RObject {

    var productsBought: List<RInt> = listOf()
    var timesProductBoughtInCurrentRefresh: Map<RInt, RInt> = mapOf()
    var nextAutoRefreshTime: Instant = now()
    var lastPlayedGauntletDivision: Byte = 0
    var isLocked: Boolean = false
    var lastPlayedGauntletLeague: Byte = 0

    override fun read(sink: InputSink) {
        productsBought = sink.readList()
        timesProductBoughtInCurrentRefresh = sink.readMap()
        nextAutoRefreshTime = sink.readInstant()
        lastPlayedGauntletDivision = sink.readByte()
        isLocked = sink.readBoolean()
        lastPlayedGauntletLeague = sink.readByte()
    }

    override fun write(sink: OutputSink) {
        sink.writeList(productsBought)
        sink.writeMap(timesProductBoughtInCurrentRefresh)
        sink.writeInstant(nextAutoRefreshTime)
        sink.writeByte(lastPlayedGauntletDivision)
        sink.writeBoolean(isLocked)
        sink.writeByte(lastPlayedGauntletLeague)
    }
}