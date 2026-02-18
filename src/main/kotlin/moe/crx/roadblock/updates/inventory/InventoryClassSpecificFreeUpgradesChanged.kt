package moe.crx.roadblock.updates.inventory

import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CarClass
import moe.crx.roadblock.objects.game.CarStatType
import moe.crx.roadblock.objects.game.FreeUpgrades

class InventoryClassSpecificFreeUpgradesChanged : RObject {

    var carStat: CarStatType = CarStatType.TopSpeed
    var carClass: CarClass = CarClass.A
    var oldFreeUpgrades: FreeUpgrades = 0
    var newFreeUpgrades: FreeUpgrades = 0

    override fun read(sink: InputSink) {
        carStat = sink.readEnum()
        carClass = sink.readEnum()
        oldFreeUpgrades = sink.readInt()
        newFreeUpgrades = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeEnum(carStat)
        sink.writeEnum(carClass)
        sink.writeInt(oldFreeUpgrades)
        sink.writeInt(newFreeUpgrades)
    }
}