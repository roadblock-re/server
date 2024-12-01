package moe.crx.roadblock.updates.inventory

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CarClass
import moe.crx.roadblock.objects.game.CarStatType
import moe.crx.roadblock.objects.game.CarUpgradeTier
import moe.crx.roadblock.objects.game.FreeUpgrades

class InventoryClassAndUnlockedTierSpecificFreeUpgradesChanged : RObject {

    var carStat: CarStatType = CarStatType.TopSpeed
    var carClass: CarClass = CarClass.A
    var tier: CarUpgradeTier = 0
    var oldFreeUpgrades: FreeUpgrades = 0
    var newFreeUpgrades: FreeUpgrades = 0

    override fun read(sink: InputSink) {
        carStat = sink.readEnum()
        carClass = sink.readEnum()
        tier = sink.readByte()
        oldFreeUpgrades = sink.readInt()
        newFreeUpgrades = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeEnum(carStat)
        sink.writeEnum(carClass)
        sink.writeByte(tier)
        sink.writeInt(oldFreeUpgrades)
        sink.writeInt(newFreeUpgrades)
    }
}