package moe.crx.roadblock.updates.bonuspass

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.FreeTLETicketsRefillsAmount

class BonusPassSystemBenefitTLETicketsRefillsAmountChanged : RObject {

    var oldAmount: FreeTLETicketsRefillsAmount = 0
    var newAmount: FreeTLETicketsRefillsAmount = 0

    override fun read(sink: InputSink) {
        oldAmount = sink.readInt()
        newAmount = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(oldAmount)
        sink.writeInt(newAmount)
    }
}