package moe.crx.roadblock.updates.inventory

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.Blueprints
import moe.crx.roadblock.objects.game.CarClass
import moe.crx.roadblock.objects.game.CarUpgradeTier

class InventoryWildcardBlueprintsChanged : RObject {

    var carClass: CarClass = CarClass.A
    var tier: CarUpgradeTier = 0
    var oldBlueprints: Blueprints = 0
    var newBlueprints: Blueprints = 0

    override fun read(sink: InputSink) {
        carClass = sink.readEnum()
        tier = sink.readByte()
        oldBlueprints = sink.readInt()
        newBlueprints = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeEnum(carClass)
        sink.writeByte(tier)
        sink.writeInt(oldBlueprints)
        sink.writeInt(newBlueprints)
    }
}