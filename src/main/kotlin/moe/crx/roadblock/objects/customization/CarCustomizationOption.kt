package moe.crx.roadblock.objects.customization

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.TRGBColor

class CarCustomizationOption : RObject {

    var materialType: Int = 0
    var color1: TRGBColor = TRGBColor()
    var color2: TRGBColor? = null

    override fun read(sink: InputSink) {
        materialType = sink.readInt()
        color1 = sink.readObject()
        color2 = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(materialType)
        sink.writeObject(color1)
        sink.writeOptional(color2)
    }
}