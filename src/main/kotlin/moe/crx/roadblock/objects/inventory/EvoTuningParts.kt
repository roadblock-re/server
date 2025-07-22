package moe.crx.roadblock.objects.inventory

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject

class EvoTuningParts : RObject {

    var ownedEngineIds: List<RInt> = listOf()
    var ownedDriveTrainIds: List<RInt> = listOf()
    var ownedNOSIds: List<RInt> = listOf()
    var ownedIntakeIds: List<RInt> = listOf()
    var ownedSKitIds: List<RInt> = listOf()

    override fun read(sink: InputSink) {
        ownedEngineIds = sink.readList()
        ownedDriveTrainIds = sink.readList()
        ownedNOSIds = sink.readList()
        ownedIntakeIds = sink.readList()
        ownedSKitIds = sink.readList()
    }

    override fun write(sink: OutputSink) {
        sink.writeList(ownedEngineIds)
        sink.writeList(ownedDriveTrainIds)
        sink.writeList(ownedNOSIds)
        sink.writeList(ownedIntakeIds)
        sink.writeList(ownedSKitIds)
    }

}
