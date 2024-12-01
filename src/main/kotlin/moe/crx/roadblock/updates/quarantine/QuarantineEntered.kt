package moe.crx.roadblock.updates.quarantine

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.QuarantineEnterReason

class QuarantineEntered : RObject {

    var timePoint: Instant = now()
    var reason: QuarantineEnterReason = QuarantineEnterReason.Cheat

    override fun read(sink: InputSink) {
        timePoint = sink.readInstant()
        reason = sink.readEnum()
    }

    override fun write(sink: OutputSink) {
        sink.writeInstant(timePoint)
        sink.writeEnum(reason)
    }
}