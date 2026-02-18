package moe.crx.roadblock.updates.inventory

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CarId

class InventoryCarLastUsageChanged : RObject {

    var carId: CarId = 0
    var oldLastUsage: Instant = now()
    var newLastUsage: Instant = now()

    override fun read(sink: InputSink) {
        carId = sink.readInt()
        oldLastUsage = sink.readInstant()
        newLastUsage = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(carId)
        sink.writeInstant(oldLastUsage)
        sink.writeInstant(newLastUsage)
    }
}