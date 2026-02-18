package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.GarageLevel
import moe.crx.roadblock.rpc.base.RequestPacket

class GainGarageLevelCheatRequest : RequestPacket() {

    var amount: GarageLevel = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        amount = sink.readShort()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeShort(amount)
    }
}