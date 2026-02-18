package moe.crx.roadblock.updates.career

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CareerEventId

class CareerRaceFinished : RObject {

    var position: Byte = 0
    var eventId: CareerEventId = 0
    var hasFinished: Boolean = false
    var wasCompleted: Boolean = false

    override fun read(sink: InputSink) {
        position = sink.readByte()
        eventId = sink.readInt()
        hasFinished = sink.readBoolean()
        wasCompleted = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeByte(position)
        sink.writeInt(eventId)
        sink.writeBoolean(hasFinished)
        sink.writeBoolean(wasCompleted)
    }
}