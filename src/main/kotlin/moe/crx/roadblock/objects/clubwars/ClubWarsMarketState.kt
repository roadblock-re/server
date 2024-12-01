package moe.crx.roadblock.objects.clubwars

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

class ClubWarsMarketState : RObject {

    var isLocked: Boolean = false
    var productsBought: List<RInt> = listOf()
    var timesProductBoughtInCurrentRefresh: Map<RInt, RInt> = mapOf()
    var nextAutoRefreshTime: Instant = now()

    override fun read(sink: InputSink) {
        isLocked = sink.readBoolean()
        productsBought = sink.readList()
        timesProductBoughtInCurrentRefresh = sink.readMap()
        nextAutoRefreshTime = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeBoolean(isLocked)
        sink.writeList(productsBought)
        sink.writeMap(timesProductBoughtInCurrentRefresh)
        sink.writeInstant(nextAutoRefreshTime)
    }
}