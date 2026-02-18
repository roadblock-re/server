package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.TLETicket
import moe.crx.roadblock.rpc.base.RequestPacket

class TLETicketsCheatRequest : RequestPacket() {

    var amount: TLETicket = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        amount = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(amount)
    }
}