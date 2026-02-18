package moe.crx.roadblock.updates.quarantine

import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.QuarantineEnterReason

class QuarantineEnterReasonChanged : RObject {

    var oldReason: QuarantineEnterReason = QuarantineEnterReason.Cheat
    var newReason: QuarantineEnterReason = QuarantineEnterReason.Cheat

    override fun read(sink: InputSink) {
        oldReason = sink.readEnum()
        newReason = sink.readEnum()
    }

    override fun write(sink: OutputSink) {
        sink.writeEnum(oldReason)
        sink.writeEnum(newReason)
    }
}