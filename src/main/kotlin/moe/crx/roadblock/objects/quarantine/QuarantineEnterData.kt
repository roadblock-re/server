package moe.crx.roadblock.objects.quarantine

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.QuarantineEnterReason

class QuarantineEnterData : RObject {

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