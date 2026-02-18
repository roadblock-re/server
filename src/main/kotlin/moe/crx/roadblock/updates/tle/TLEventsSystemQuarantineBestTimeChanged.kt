package moe.crx.roadblock.updates.tle

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CarId
import moe.crx.roadblock.objects.game.CarRank
import moe.crx.roadblock.objects.tle.TLEventId

class TLEventsSystemQuarantineBestTimeChanged : RObject {

    var eventId: TLEventId = TLEventId()
    var bestTimeInMicroseconds: Int = 0
    var carId: CarId = 0
    var carRank: CarRank = 0
    var timestamp: Instant = now()

    override fun read(sink: InputSink) {
        eventId = sink.readObject()
        bestTimeInMicroseconds = sink.readInt()
        carId = sink.readInt()
        carRank = sink.readShort()
        timestamp = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(eventId)
        sink.writeInt(bestTimeInMicroseconds)
        sink.writeInt(carId)
        sink.writeShort(carRank)
        sink.writeInstant(timestamp)
    }
}