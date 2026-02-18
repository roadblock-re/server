package moe.crx.roadblock.objects.inventory

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.Blueprints
import moe.crx.roadblock.objects.game.CarUpgradeTier

class WildcardBlueprintState : RObject {

    var upgradeTier: CarUpgradeTier = 0
    var amount: Blueprints = 0

    override fun read(sink: InputSink) {
        upgradeTier = sink.readByte()
        amount = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeByte(upgradeTier)
        sink.writeInt(amount)
    }
}