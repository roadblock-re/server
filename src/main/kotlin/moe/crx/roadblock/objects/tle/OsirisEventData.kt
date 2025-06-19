package moe.crx.roadblock.objects.tle

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RByteArray
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RString
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.CalendarEventVersion

class OsirisEventData : RObject {

    var version: CalendarEventVersion = 0
    var eventId: CalendarEventId = ""
    var startDate: Instant = now()
    var endDate: Instant = now()
    var participationDate: Instant = now()
    var dbRawData: RByteArray? = null
    var eTag: RString? = null

    override fun read(sink: InputSink) {
        version = sink.readInt()
        eventId = sink.readString()
        startDate = sink.readInstant()
        endDate = sink.readInstant()
        participationDate = sink.readInstant()
        dbRawData = sink.readOptional()
        eTag = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(version)
        sink.writeString(eventId)
        sink.writeInstant(startDate)
        sink.writeInstant(endDate)
        sink.writeInstant(participationDate)
        sink.writeOptional(dbRawData)
        sink.writeOptional(eTag)
    }
}