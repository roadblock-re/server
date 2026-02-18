package moe.crx.roadblock.updates.career

import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CareerEventId
import moe.crx.roadblock.objects.game.SatelliteRewardState

class CareerEventSatelliteRewardStateChanged : RObject {

    var eventId: CareerEventId = 0
    var oldState: SatelliteRewardState = SatelliteRewardState.Locked
    var newState: SatelliteRewardState = SatelliteRewardState.Locked

    override fun read(sink: InputSink) {
        eventId = sink.readInt()
        oldState = sink.readEnum()
        newState = sink.readEnum()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(eventId)
        sink.writeEnum(oldState)
        sink.writeEnum(newState)
    }
}