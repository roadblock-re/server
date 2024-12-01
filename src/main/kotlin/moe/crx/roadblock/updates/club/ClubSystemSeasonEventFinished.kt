package moe.crx.roadblock.updates.club

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId

class ClubSystemSeasonEventFinished : RObject {

    var id: CalendarEventId = ""
    var canClaimMilestones: Boolean = false

    override fun read(sink: InputSink) {
        id = sink.readString()
        canClaimMilestones = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(id)
        sink.writeBoolean(canClaimMilestones)
    }
}