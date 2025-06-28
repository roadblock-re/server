package moe.crx.roadblock.objects.club

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RString

class ClubDonationData : RObject {

    var requestedItem: Int = 0
    var lastRequestTimestamp: Instant = now()
    var templateId: RString? = null

    override fun read(sink: InputSink) {
        requestedItem = sink.readInt()
        lastRequestTimestamp = sink.readInstant()
        templateId = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(requestedItem)
        sink.writeInstant(lastRequestTimestamp)
        sink.writeOptional(templateId)
    }
}