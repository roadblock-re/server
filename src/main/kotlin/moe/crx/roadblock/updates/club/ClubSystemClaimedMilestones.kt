package moe.crx.roadblock.updates.club

import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId

class ClubSystemClaimedMilestones : RObject {

    var eventId: CalendarEventId = ""
    var milestones: List<RInt> = listOf()  // ClubSeasonMilestoneId

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        milestones = sink.readList()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeList(milestones)
    }
}