package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.GarageValue
import moe.crx.roadblock.rpc.base.RequestPacket

class GainGarageValueCheatRequest : RequestPacket() {

    var amount: GarageValue = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        amount = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(amount)
    }
}