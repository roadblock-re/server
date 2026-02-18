package moe.crx.roadblock.updates.miscellaneous

import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RBoolean
import moe.crx.roadblock.objects.base.RObject

class MiscellaneousUserGPDRComplianceChanged : RObject {

    var oldGdprCompliance: RBoolean? = null
    var newGdprCompliance: RBoolean? = null

    override fun read(sink: InputSink) {
        oldGdprCompliance = sink.readOptional()
        newGdprCompliance = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeOptional(oldGdprCompliance)
        sink.writeOptional(newGdprCompliance)
    }
}