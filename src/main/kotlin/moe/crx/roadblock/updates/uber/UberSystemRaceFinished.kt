package moe.crx.roadblock.updates.uber

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.CarId

class UberSystemRaceFinished : RObject {

    var eventId: CalendarEventId = ""
    var carId: CarId = 0
    var position: Byte = 0
    var hasFinished: Boolean = false

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        carId = sink.readInt()
        position = sink.readByte()
        hasFinished = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeInt(carId)
        sink.writeByte(position)
        sink.writeBoolean(hasFinished)
    }
}