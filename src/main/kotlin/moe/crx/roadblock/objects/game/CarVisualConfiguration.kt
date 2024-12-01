package moe.crx.roadblock.objects.game

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.VariantIO.readVariant
import moe.crx.roadblock.io.VariantIO.writeVariant
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RVoid
import moe.crx.roadblock.objects.customization.*

class CarVisualConfiguration : RObject {

    var configuration: RObject = RVoid()
    var topConfig: RInt? = null
    var customParts: CustomParts? = null
    var extraParameters: ExtraCustomizationParameters = ExtraCustomizationParameters()

    override fun read(sink: InputSink) {
        configuration = sink.readVariant(
            CarOfficialVisualOption::class,
            CarCustomizationOption::class,
            CarDecalVisualOption::class,
        )
        topConfig = sink.readOptional()
        customParts = sink.readOptional()
        extraParameters = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        sink.writeVariant(
            configuration,
            CarOfficialVisualOption::class,
            CarCustomizationOption::class,
            CarDecalVisualOption::class,
        )
        sink.writeOptional(topConfig)
        sink.writeOptional(customParts)
        sink.writeObject(extraParameters)
    }
}