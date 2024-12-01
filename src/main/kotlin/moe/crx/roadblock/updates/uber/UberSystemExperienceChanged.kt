package moe.crx.roadblock.updates.uber

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.UberExperience

class UberSystemExperienceChanged : RObject {

    var eventId: CalendarEventId = ""
    var oldExperience: UberExperience = 0
    var newExperience: UberExperience = 0

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        oldExperience = sink.readInt()
        newExperience = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeInt(oldExperience)
        sink.writeInt(newExperience)
    }
}