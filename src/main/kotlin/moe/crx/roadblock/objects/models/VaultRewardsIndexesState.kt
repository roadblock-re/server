package moe.crx.roadblock.objects.models

import moe.crx.roadblock.io.MapIO.readMap
import moe.crx.roadblock.io.MapIO.writeMap
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.vault.EventRewardsIndexesState

class VaultRewardsIndexesState : RObject {

    var rewardsIndexesDataById: Map<RInt, EventRewardsIndexesState> = mapOf()

    override fun read(sink: InputSink) {
        rewardsIndexesDataById = sink.readMap()
    }

    override fun write(sink: OutputSink) {
        sink.writeMap(rewardsIndexesDataById)
    }

}
