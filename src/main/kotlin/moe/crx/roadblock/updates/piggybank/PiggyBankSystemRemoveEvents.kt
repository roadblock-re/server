package moe.crx.roadblock.updates.piggybank

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RString

class PiggyBankSystemRemoveEvents : RObject {

    var eventIds: List<RString> = listOf() // CalendarEventId

    override fun read(sink: InputSink) {
        eventIds = sink.readList()
    }

    override fun write(sink: OutputSink) {
        sink.writeList(eventIds)
    }
}