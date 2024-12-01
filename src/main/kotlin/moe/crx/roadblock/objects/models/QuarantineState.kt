package moe.crx.roadblock.objects.models

import moe.crx.roadblock.io.MapIO.readMap
import moe.crx.roadblock.io.MapIO.writeMap
import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RByte
import moe.crx.roadblock.objects.base.RInstant
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.quarantine.QuarantineEnterData
import moe.crx.roadblock.objects.quarantine.QuarantineEvidenceData
import moe.crx.roadblock.objects.quarantine.QuarantineExitData

class QuarantineState : RObject {

    var currentEvidences: Map<RByte, QuarantineEvidenceData> = mapOf()
    var quarantinedStatus: Int = 0
    var mostRecentEvidenceTime: RInstant? = null
    var mostRecentExitData: QuarantineExitData? = null
    var mostRecentEnterData: QuarantineEnterData? = null

    override fun read(sink: InputSink) {
        currentEvidences = sink.readMap()
        quarantinedStatus = sink.readInt()
        mostRecentEvidenceTime = sink.readOptional()
        mostRecentExitData = sink.readOptional()
        mostRecentEnterData = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeMap(currentEvidences)
        sink.writeInt(quarantinedStatus)
        sink.writeOptional(mostRecentEvidenceTime)
        sink.writeOptional(mostRecentExitData)
        sink.writeOptional(mostRecentEnterData)
    }
}