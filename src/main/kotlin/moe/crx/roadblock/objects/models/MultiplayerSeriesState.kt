package moe.crx.roadblock.objects.models

import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.io.MapIO.readMap
import moe.crx.roadblock.game.io.MapIO.writeMap
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInstant
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RShort
import moe.crx.roadblock.objects.multiplayer.MultiplayerSeriesSeriesState

class MultiplayerSeriesState : RObject {

    var series: Map<RInt, MultiplayerSeriesSeriesState> = mapOf()
    var alreadyProcessedRaceTokenTransactions: List<RInt> = listOf()
    var isLocked: Boolean = false
    var mostRecentDisconnections: List<RInstant> = listOf()
    var claimedTriumphRewardIds: List<RShort> = listOf()

    override fun read(sink: InputSink) {
        series = sink.readMap()
        alreadyProcessedRaceTokenTransactions = sink.readList()
        isLocked = sink.readBoolean()
        mostRecentDisconnections = sink.readList()
        if (sink newer "24.0.0") {
            claimedTriumphRewardIds = sink.readList()
        }
    }

    override fun write(sink: OutputSink) {
        sink.writeMap(series)
        sink.writeList(alreadyProcessedRaceTokenTransactions)
        sink.writeBoolean(isLocked)
        sink.writeList(mostRecentDisconnections)
        if (sink newer "24.0.0") {
            sink.writeList(claimedTriumphRewardIds)
        }
    }
}