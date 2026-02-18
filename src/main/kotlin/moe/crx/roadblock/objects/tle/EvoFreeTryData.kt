package moe.crx.roadblock.objects.tle

import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject

class EvoFreeTryData : RObject {

    var optEngineId: RInt? = null
    var optSKitId: RInt? = null
    var optIntakeId: RInt? = null
    var optDrivetrainId: RInt? = null
    var optNOSId: RInt? = null

    override fun read(sink: InputSink) {
        optEngineId = sink.readOptional()
        optSKitId = sink.readOptional()
        optIntakeId = sink.readOptional()
        optDrivetrainId = sink.readOptional()
        optNOSId = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeOptional(optEngineId)
        sink.writeOptional(optSKitId)
        sink.writeOptional(optIntakeId)
        sink.writeOptional(optDrivetrainId)
        sink.writeOptional(optNOSId)
    }
}