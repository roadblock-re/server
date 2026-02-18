package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.rpc.base.RequestPacket

class MultiplayerChallengesClaimRewardRequest : RequestPacket() {

    var eventId: CalendarEventId = ""
    var stageId: Byte = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        eventId = sink.readString()
        stageId = sink.readByte()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(eventId)
        sink.writeByte(stageId)
    }
}