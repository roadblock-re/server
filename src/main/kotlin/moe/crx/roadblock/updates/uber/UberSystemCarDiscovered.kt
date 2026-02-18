package moe.crx.roadblock.updates.uber

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.CarId

class UberSystemCarDiscovered : RObject {

    var eventId: CalendarEventId = ""
    var carId: CarId = 0

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        carId = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeInt(carId)
    }
}