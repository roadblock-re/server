package moe.crx.roadblock.objects.tle

import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject

class TLEventRaceData : RObject {

    var timeInMicroseconds: Int = 0
    var carId: Int = 0
    var carRank: Short = 0
    var isCarOverclocked: Boolean = false
    var collectedItemCount: Int = 0
    var driveMeters: Int = 0
    var optEvoTuningVisualArchetype: RInt? = null

    override fun read(sink: InputSink) {
        timeInMicroseconds = sink.readInt()
        carId = sink.readInt()
        carRank = sink.readShort()
        if (sink newer "24.0.0") {
            isCarOverclocked = sink.readBoolean()
        }
        if (sink newer "24.6.0") {
            collectedItemCount = sink.readInt()
            driveMeters = sink.readInt()
        }
        if (sink newer "47.1.0") {
            optEvoTuningVisualArchetype = sink.readOptional()
        }
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(timeInMicroseconds)
        sink.writeInt(carId)
        sink.writeShort(carRank)
        if (sink newer "24.0.0") {
            sink.writeBoolean(isCarOverclocked)
        }
        if (sink newer "24.6.0") {
            sink.writeInt(collectedItemCount)
            sink.writeInt(driveMeters)
        }
        if (sink newer "47.1.0") {
            sink.writeOptional(optEvoTuningVisualArchetype)
        }
    }
}