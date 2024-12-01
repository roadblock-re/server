package moe.crx.roadblock.updates.inventory

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CarId
import moe.crx.roadblock.objects.game.CarStatType
import moe.crx.roadblock.objects.game.UpgradeItemSlotId

class InventoryCarUpgradeItemChanged : RObject {

    var carId: CarId = 0
    var carStat: CarStatType = CarStatType.TopSpeed
    var slotId: UpgradeItemSlotId = 0
    var applied: Boolean = false

    override fun read(sink: InputSink) {
        carId = sink.readInt()
        carStat = sink.readEnum()
        slotId = sink.readInt()
        applied = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(carId)
        sink.writeEnum(carStat)
        sink.writeInt(slotId)
        sink.writeBoolean(applied)
    }
}