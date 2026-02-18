package moe.crx.roadblock.objects.settings

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class Localization : RObject {

    var language: Int = 0
    var script: Int = 0
    var region: Int = 0

    override fun read(sink: InputSink) {
        language = sink.readInt()
        script = sink.readInt()
        region = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(language)
        sink.writeInt(script)
        sink.writeInt(region)
    }
}