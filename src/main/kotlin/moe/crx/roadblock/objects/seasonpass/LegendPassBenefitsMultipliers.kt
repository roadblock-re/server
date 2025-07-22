package moe.crx.roadblock.objects.seasonpass

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject

class LegendPassBenefitsMultipliers : RObject {

    var timeBetweenBoxes: Int = 0
    var extraMaintenanceSlots: Short = 0
    var boosters: List<RInt> = listOf()
    var hasNextRefillTimePoint: Boolean = false
    var nextRefillTimePoint: Instant = now()
    var hasUnlimitedFuelInCareerMode: Boolean = false
    var hasUnlimitedTicketsInTLE: Boolean = false

    override fun read(sink: InputSink) {
        timeBetweenBoxes = sink.readInt()
        extraMaintenanceSlots = sink.readShort()
        boosters = sink.readList()
        hasNextRefillTimePoint = sink.readBoolean()
        nextRefillTimePoint = sink.readInstant()
        if (sink newer "24.6.0") {
            hasUnlimitedFuelInCareerMode = sink.readBoolean()
        }
        if (sink newer "45.0.0") {
            hasUnlimitedTicketsInTLE = sink.readBoolean()
        }
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(timeBetweenBoxes)
        sink.writeShort(extraMaintenanceSlots)
        sink.writeList(boosters)
        sink.writeBoolean(hasNextRefillTimePoint)
        sink.writeInstant(nextRefillTimePoint)
        if (sink newer "24.6.0") {
            sink.writeBoolean(hasUnlimitedFuelInCareerMode)
        }
        if (sink newer "45.0.0") {
            sink.writeBoolean(hasUnlimitedTicketsInTLE)
        }
    }
}