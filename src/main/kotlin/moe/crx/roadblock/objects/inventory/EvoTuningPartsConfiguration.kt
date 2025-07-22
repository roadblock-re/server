package moe.crx.roadblock.objects.inventory

import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject

class EvoTuningPartsConfiguration : RObject {

    var optEngineId: RInt? = null
    var optDriveTrainId: RInt? = null
    var optNOSId: RInt? = null
    var optIntakeId: RInt? = null
    var optSKitId: RInt? = null

    override fun read(sink: InputSink) {
        optEngineId = sink.readOptional()
        optDriveTrainId = sink.readOptional()
        optNOSId = sink.readOptional()
        optIntakeId = sink.readOptional()
        optSKitId = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeOptional(optEngineId)
        sink.writeOptional(optDriveTrainId)
        sink.writeOptional(optNOSId)
        sink.writeOptional(optIntakeId)
        sink.writeOptional(optSKitId)
    }

}
