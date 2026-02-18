package moe.crx.roadblock.objects.tle

import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject

class TLEventId : RObject {

    var eventId: String = ""
    var specialEventIndex: RInt? = null

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        specialEventIndex = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeOptional(specialEventIndex)
    }
}