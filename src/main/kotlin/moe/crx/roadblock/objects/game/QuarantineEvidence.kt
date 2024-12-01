package moe.crx.roadblock.objects.game

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class QuarantineEvidence : RObject {

    var type: QuarantineEvidenceType = QuarantineEvidenceType.NITRO_MAGICAL_GAIN
    var source: QuarantineEvidenceSource = QuarantineEvidenceSource.GameplayServer
    var timestamp: Instant = now()

    override fun read(sink: InputSink) {
        type = sink.readEnum()
        source = sink.readEnum()
        timestamp = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeEnum(type)
        sink.writeEnum(source)
        sink.writeInstant(timestamp)
    }
}