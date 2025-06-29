package moe.crx.roadblock.updates.inventory

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CarCustomizationLockableSection
import moe.crx.roadblock.objects.game.CarId

class InventoryCarCustomizationLocksChanged : RObject {

    var carId: CarId = 0
    var section: CarCustomizationLockableSection =
        CarCustomizationLockableSection.Customization
    var oldState: Boolean = false
    var newState: Boolean = false

    override fun read(sink: InputSink) {
        carId = sink.readInt()
        section = sink.readEnum()
        oldState = sink.readBoolean()
        newState = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(carId)
        sink.writeEnum(section)
        sink.writeBoolean(oldState)
        sink.writeBoolean(newState)
    }
}