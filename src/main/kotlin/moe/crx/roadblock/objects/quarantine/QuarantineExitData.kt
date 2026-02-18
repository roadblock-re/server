package moe.crx.roadblock.objects.quarantine

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.io.MapIO.readMap
import moe.crx.roadblock.game.io.MapIO.writeMap
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject

class QuarantineExitData : RObject {

    var timePoint: Instant = now()
    var reason: QuarantineExitReason = QuarantineExitReason.Cheat
    var evidences: Map<RInt, QuarantineEvidenceData> = mapOf()

    override fun read(sink: InputSink) {
        timePoint = sink.readInstant()
        reason = sink.readEnum()
        evidences = sink.readMap()
    }

    override fun write(sink: OutputSink) {
        sink.writeInstant(timePoint)
        sink.writeEnum(reason)
        sink.writeMap(evidences)
    }
}