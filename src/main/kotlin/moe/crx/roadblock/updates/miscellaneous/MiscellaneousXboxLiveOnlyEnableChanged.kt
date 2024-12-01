package moe.crx.roadblock.updates.miscellaneous

import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RBoolean
import moe.crx.roadblock.objects.base.RObject

class MiscellaneousXboxLiveOnlyEnableChanged : RObject {

    var oldEnable: RBoolean? = null
    var newEnable: RBoolean? = null

    override fun read(sink: InputSink) {
        oldEnable = sink.readOptional()
        newEnable = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeOptional(oldEnable)
        sink.writeOptional(newEnable)
    }
}