package moe.crx.roadblock.objects.models

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.MapIO.readMap
import moe.crx.roadblock.io.MapIO.writeMap
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RString
import moe.crx.roadblock.objects.gacha.GachaEventEntry
import moe.crx.roadblock.objects.gacha.GachaId

class GachaSystemSystemState : RObject {

    var isLocked: Boolean = false
    var nextRetentionBoxReadyTime: Instant = now()
    var openedGachaBoxes: List<GachaId> = listOf()
    var openedEventBoxes: Map<RString, GachaEventEntry> = mapOf()
    var nextSponsorshipRetentionBoxReadyTime: Instant = now()

    override fun read(sink: InputSink) {
        isLocked = sink.readBoolean()
        nextRetentionBoxReadyTime = sink.readInstant()
        openedGachaBoxes = sink.readList()
        openedEventBoxes = sink.readMap()
        if (sink newer "24.0.0") {
            nextSponsorshipRetentionBoxReadyTime = sink.readInstant()
        }
    }

    override fun write(sink: OutputSink) {
        sink.writeBoolean(isLocked)
        sink.writeInstant(nextRetentionBoxReadyTime)
        sink.writeList(openedGachaBoxes)
        sink.writeMap(openedEventBoxes)
        if (sink newer "24.0.0") {
            sink.writeInstant(nextSponsorshipRetentionBoxReadyTime)
        }
    }
}