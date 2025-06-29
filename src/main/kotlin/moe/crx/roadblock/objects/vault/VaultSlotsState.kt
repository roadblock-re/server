package moe.crx.roadblock.objects.vault

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.VaultEventId
import moe.crx.roadblock.objects.game.VaultSlotId

class VaultSlotsState : RObject {

    var slotId: VaultSlotId = 0
    var assignedEventId: VaultEventId = 0
    var eventAssignedTimestamp: Instant = now()

    override fun read(sink: InputSink) {
        slotId = sink.readShort()
        assignedEventId = sink.readInt()
        eventAssignedTimestamp = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeShort(slotId)
        sink.writeInt(assignedEventId)
        sink.writeInstant(eventAssignedTimestamp)
    }
}