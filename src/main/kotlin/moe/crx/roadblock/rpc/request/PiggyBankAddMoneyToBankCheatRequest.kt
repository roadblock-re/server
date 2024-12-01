package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.Money
import moe.crx.roadblock.rpc.base.RequestPacket

class PiggyBankAddMoneyToBankCheatRequest : RequestPacket() {

    var moneyToAdd: Money = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        moneyToAdd = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(moneyToAdd)
    }
}