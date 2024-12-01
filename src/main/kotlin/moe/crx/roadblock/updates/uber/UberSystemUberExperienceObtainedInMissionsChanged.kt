package moe.crx.roadblock.updates.uber

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.UberExperience
import moe.crx.roadblock.objects.game.UberTierId

class UberSystemUberExperienceObtainedInMissionsChanged : RObject {

    var eventId: CalendarEventId = ""
    var tierId: UberTierId = 0
    var oldExperience: UberExperience = 0
    var newExperience: UberExperience = 0

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        tierId = sink.readInt()
        oldExperience = sink.readInt()
        newExperience = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeInt(tierId)
        sink.writeInt(oldExperience)
        sink.writeInt(newExperience)
    }
}