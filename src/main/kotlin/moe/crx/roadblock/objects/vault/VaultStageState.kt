package moe.crx.roadblock.objects.vault

import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class VaultStageState : RObject {

    var soloRewardsData: VaultSoloRewardsState = VaultSoloRewardsState()

    override fun read(sink: InputSink) {
        soloRewardsData = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(soloRewardsData)
    }
}