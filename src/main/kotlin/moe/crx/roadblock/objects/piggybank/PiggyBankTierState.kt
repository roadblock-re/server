package moe.crx.roadblock.objects.piggybank

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class PiggyBankTierState : RObject {

    var attempts: Int = 0

    override fun read(sink: InputSink) {
        attempts = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(attempts)
    }
}