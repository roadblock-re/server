package moe.crx.roadblock.objects.models

import moe.crx.roadblock.game.io.MapIO.readMap
import moe.crx.roadblock.game.io.MapIO.writeMap
import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RString
import moe.crx.roadblock.objects.bonuspass.BonusPassState
import moe.crx.roadblock.objects.bonuspass.MultiplayerBenefitsState
import moe.crx.roadblock.objects.bonuspass.TLEBenefitsState

class BonusPassSystemState : RObject {

    var events: Map<RString, BonusPassState> = mapOf()
    var multiplayerBenefits: MultiplayerBenefitsState = MultiplayerBenefitsState()
    var tleBenefits: TLEBenefitsState = TLEBenefitsState() // 3.9+ only (also maybe 3.8)

    override fun read(sink: InputSink) {
        events = sink.readMap()
        multiplayerBenefits = sink.readObject()
        tleBenefits = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        sink.writeMap(events)
        sink.writeObject(multiplayerBenefits)
        sink.writeObject(tleBenefits)
    }
}