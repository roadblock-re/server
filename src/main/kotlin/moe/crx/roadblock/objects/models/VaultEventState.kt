package moe.crx.roadblock.objects.models

import moe.crx.roadblock.io.MapIO.readMap
import moe.crx.roadblock.io.MapIO.writeMap
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.vault.VaultProgressionRewardsState
import moe.crx.roadblock.objects.vault.VaultStageState

class VaultEventState : RObject {

    var eventExtendedData: VaultEventExtendedData = VaultEventExtendedData()
    var stagesDataById: Map<RInt, VaultStageState> = mapOf()
    var progressionRewardsData: VaultProgressionRewardsState = VaultProgressionRewardsState()

    override fun read(sink: InputSink) {
        eventExtendedData = sink.readObject()
        stagesDataById = sink.readMap()
        progressionRewardsData = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(eventExtendedData)
        sink.writeMap(stagesDataById)
        sink.writeObject(progressionRewardsData)
    }

}
