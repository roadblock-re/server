package moe.crx.roadblock.objects.item

import moe.crx.roadblock.io.VariantIO.readVariant
import moe.crx.roadblock.io.VariantIO.writeVariant
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RVoid
import moe.crx.roadblock.objects.game.CarId

class CustomizationUnlock : RObject {

    var carId: CarId = 0
    var customization: RObject = RVoid()

    override fun read(sink: InputSink) {
        carId = sink.readInt()
        customization = sink.readVariant(
            CarDecalVisualUnlock::class,
            CarCustomPartUnlock::class,
        )
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(carId)
        sink.writeVariant(
            customization,
            CarDecalVisualUnlock::class,
            CarCustomPartUnlock::class,
        )
    }
}