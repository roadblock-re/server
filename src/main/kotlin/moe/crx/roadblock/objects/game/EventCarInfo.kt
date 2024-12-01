package moe.crx.roadblock.objects.game

import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class EventCarInfo : RObject {

    var carId: CarId = 0
    var freeTry: FreeTryInfo? = null
    var carPreset: CarPreset? = null

    override fun read(sink: InputSink) {
        carId = sink.readInt()
        freeTry = sink.readOptional()
        carPreset = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(carId)
        sink.writeOptional(freeTry)
        sink.writeOptional(carPreset)
    }
}