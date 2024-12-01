package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.ClubSeasonMilestoneId
import moe.crx.roadblock.rpc.base.RequestPacket

class ClaimClubSeasonMilestoneRequest : RequestPacket() {

    var eventId: CalendarEventId = ""
    var milestoneId: ClubSeasonMilestoneId = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        eventId = sink.readString()
        milestoneId = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(eventId)
        sink.writeInt(milestoneId)
    }
}