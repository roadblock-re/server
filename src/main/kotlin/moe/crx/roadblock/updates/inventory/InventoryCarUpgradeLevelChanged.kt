package moe.crx.roadblock.updates.inventory

import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CarId
import moe.crx.roadblock.objects.game.CarStatType
import moe.crx.roadblock.objects.game.CarUpgradeLevel

class InventoryCarUpgradeLevelChanged : RObject {

    var carId: CarId = 0
    var carStat: CarStatType = CarStatType.TopSpeed
    var oldLevel: CarUpgradeLevel = 0
    var newLevel: CarUpgradeLevel = 0

    override fun read(sink: InputSink) {
        carId = sink.readInt()
        carStat = sink.readEnum()
        oldLevel = sink.readByte()
        newLevel = sink.readByte()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(carId)
        sink.writeEnum(carStat)
        sink.writeByte(oldLevel)
        sink.writeByte(newLevel)
    }
}