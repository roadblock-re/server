package moe.crx.roadblock.objects.tle

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RByte
import moe.crx.roadblock.objects.base.RObject

class TLEventLastRace : RObject {

    var timeInMicroseconds: Int = 0
    var carId: Int = 0
    var obtainedSoloRewardsIndices: List<RByte> = listOf()
    var maintenanceEnabled: Boolean = false

    override fun read(sink: InputSink) {
        timeInMicroseconds = sink.readInt()
        carId = sink.readInt()
        obtainedSoloRewardsIndices = sink.readList()
        maintenanceEnabled = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(timeInMicroseconds)
        sink.writeInt(carId)
        sink.writeList(obtainedSoloRewardsIndices)
        sink.writeBoolean(maintenanceEnabled)
    }
}