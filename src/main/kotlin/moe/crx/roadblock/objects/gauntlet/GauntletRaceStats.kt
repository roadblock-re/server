package moe.crx.roadblock.objects.gauntlet

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CarId
import moe.crx.roadblock.objects.game.CarRank

class GauntletRaceStats : RObject {

    var time: Instant = now()
    var carId: CarId = 0
    var carRank: CarRank = 0
    var isOverclocked: Boolean = false

    override fun read(sink: InputSink) {
        time = sink.readInstant()
        carId = sink.readInt()
        carRank = sink.readShort()
        isOverclocked = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeInstant(time)
        sink.writeInt(carId)
        sink.writeShort(carRank)
        sink.writeBoolean(isOverclocked)
    }

}
