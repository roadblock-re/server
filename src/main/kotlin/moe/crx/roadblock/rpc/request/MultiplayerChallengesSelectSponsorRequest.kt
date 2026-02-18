package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.CarId
import moe.crx.roadblock.rpc.base.RequestPacket

class MultiplayerChallengesSelectSponsorRequest : RequestPacket() {

    var eventId: CalendarEventId = ""
    var sponsorId: Int = 0
    var carId: CarId = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        eventId = sink.readString()
        sponsorId = sink.readInt()
        carId = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(eventId)
        sink.writeInt(sponsorId)
        sink.writeInt(carId)
    }
}