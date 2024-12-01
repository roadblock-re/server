package moe.crx.roadblock.objects.customization

import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.TRGBColor

class ExtraCustomizationParameters : RObject {

    var caliperColor: TRGBColor? = null
    var neonColor: TRGBColor? = null
    var rimsConfig: RimsConfig? = null

    override fun read(sink: InputSink) {
        caliperColor = sink.readOptional()
        neonColor = sink.readOptional()
        rimsConfig = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeOptional(caliperColor)
        sink.writeOptional(neonColor)
        sink.writeOptional(rimsConfig)
    }
}