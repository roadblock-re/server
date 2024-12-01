package moe.crx.roadblock.updates.uber

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId

class UberSystemMilestoneAchieved : RObject {

    var eventId: CalendarEventId = ""
    var milestoneIdx: Int = 0

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        milestoneIdx = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeInt(milestoneIdx)
    }
}