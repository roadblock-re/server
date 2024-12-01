package moe.crx.roadblock.updates.inventory

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CarId
import moe.crx.roadblock.objects.game.PlayModeType
import moe.crx.roadblock.objects.game.RaceCount

class InventoryCarRacesFinishedChanged : RObject {

    var carId: CarId = 0
    var mode: PlayModeType = PlayModeType.Career
    var oldCount: RaceCount = 0
    var newCount: RaceCount = 0

    override fun read(sink: InputSink) {
        carId = sink.readInt()
        mode = sink.readEnum()
        oldCount = sink.readShort()
        newCount = sink.readShort()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(carId)
        sink.writeEnum(mode)
        sink.writeShort(oldCount)
        sink.writeShort(newCount)
    }
}