package moe.crx.roadblock.objects.vault

import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.io.MapIO.readMap
import moe.crx.roadblock.game.io.MapIO.writeMap
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject

class EventRewardsIndexesState : RObject {

    var soloRewardsIndexesDataByStage: Map<RInt, SoloRewardsIndexesState> = mapOf()
    var progressionRewardsIndexesData: List<RInt> = listOf()

    override fun read(sink: InputSink) {
        soloRewardsIndexesDataByStage = sink.readMap()
        progressionRewardsIndexesData = sink.readList()
    }

    override fun write(sink: OutputSink) {
        sink.writeMap(soloRewardsIndexesDataByStage)
        sink.writeList(progressionRewardsIndexesData)
    }
}