package moe.crx.roadblock.objects.game

import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RDouble
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RString

class GenericUserRegionsPreferences : RObject {

    var region: RString? = null
    var latency: RDouble? = null

    override fun read(sink: InputSink) {
        region = sink.readOptional()
        latency = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeOptional(region)
        sink.writeOptional(latency)
    }
}