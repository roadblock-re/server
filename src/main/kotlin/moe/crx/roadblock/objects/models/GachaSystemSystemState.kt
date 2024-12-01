package moe.crx.roadblock.objects.models

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RShort
import moe.crx.roadblock.objects.gacha.GachaEventEntry

class GachaSystemSystemState : RObject {

    var isLocked: Boolean = false
    var nextRetentionBoxReadyTime: Instant = now()
    var openedGachaBoxes: List<RShort> = listOf()
    var openedEventBoxes: List<GachaEventEntry> = listOf()

    override fun read(sink: InputSink) {
        isLocked = sink.readBoolean()
        nextRetentionBoxReadyTime = sink.readInstant()
        openedGachaBoxes = sink.readList()
        openedEventBoxes = sink.readList()
    }

    override fun write(sink: OutputSink) {
        sink.writeBoolean(isLocked)
        sink.writeInstant(nextRetentionBoxReadyTime)
        sink.writeList(openedGachaBoxes)
        sink.writeList(openedEventBoxes)
    }
}