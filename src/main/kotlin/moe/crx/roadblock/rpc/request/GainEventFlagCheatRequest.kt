package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.CareerEventId
import moe.crx.roadblock.rpc.base.RequestPacket

class GainEventFlagCheatRequest : RequestPacket() {

    var eventId: CareerEventId = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        eventId = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(eventId)
    }
}