package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.TrackingEvent
import moe.crx.roadblock.rpc.base.RequestPacket

class SendTrackingEventsRequest : RequestPacket() {

    // TODO Implement TrackingEvent
    var events: List<TrackingEvent> = listOf()

    override fun read(sink: InputSink) {
        super.read(sink)
        //events = sink.readList()
        sink.readBytes(sink.available())
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        //sink.writeList(events)
        sink.writeInt(0)
    }
}