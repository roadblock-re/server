package moe.crx.roadblock.updates.career

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CareerEventId
import moe.crx.roadblock.objects.game.CareerFlagId

class CareerEventFlagChanged : RObject {

    var eventId: CareerEventId = 0
    var flagId: CareerFlagId = 0
    var obtained: Boolean = false

    override fun read(sink: InputSink) {
        eventId = sink.readInt()
        flagId = sink.readInt()
        obtained = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(eventId)
        sink.writeInt(flagId)
        sink.writeBoolean(obtained)
    }
}