package moe.crx.roadblock.updates.inventory

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CarId
import moe.crx.roadblock.objects.game.ConsecutiveDays

class InventoryCarConsecutiveUsedDaysChanged : RObject {

    var carId: CarId = 0
    var oldConsecutiveDays: ConsecutiveDays = 0
    var newConsecutiveDays: ConsecutiveDays = 0

    override fun read(sink: InputSink) {
        carId = sink.readInt()
        oldConsecutiveDays = sink.readInt()
        newConsecutiveDays = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(carId)
        sink.writeInt(oldConsecutiveDays)
        sink.writeInt(newConsecutiveDays)
    }
}