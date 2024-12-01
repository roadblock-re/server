package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.rpc.base.RequestPacket

class TimeLimitedSpecialEventClaimProgressionRewardRequest : RequestPacket() {

    var eventId: CalendarEventId = ""
    var rewardIdx: Byte = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        eventId = sink.readString()
        rewardIdx = sink.readByte()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(eventId)
        sink.writeByte(rewardIdx)
    }
}