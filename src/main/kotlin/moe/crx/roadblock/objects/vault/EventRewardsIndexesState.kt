package moe.crx.roadblock.objects.vault

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.MapIO.readMap
import moe.crx.roadblock.io.MapIO.writeMap
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
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