package moe.crx.roadblock.objects.customization

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.TRGBColor

class RimsConfig : RObject {

    var materialType: Int = 0
    var color: TRGBColor = TRGBColor()

    override fun read(sink: InputSink) {
        materialType = sink.readInt()
        color = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(materialType)
        sink.writeObject(color)
    }
}