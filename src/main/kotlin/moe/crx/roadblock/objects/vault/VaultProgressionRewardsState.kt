package moe.crx.roadblock.objects.vault

import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.io.MapIO.readMap
import moe.crx.roadblock.game.io.MapIO.writeMap
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject

class VaultProgressionRewardsState : RObject {

    var stagesProgressionLevel: Map<RInt, RInt> = mapOf()
    var progressionRewardsStatus: List<RInt> = listOf()

    override fun read(sink: InputSink) {
        stagesProgressionLevel = sink.readMap()
        progressionRewardsStatus = sink.readList()
    }

    override fun write(sink: OutputSink) {
        sink.writeMap(stagesProgressionLevel)
        sink.writeList(progressionRewardsStatus)
    }
}