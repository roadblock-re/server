package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.RefundRequestData
import moe.crx.roadblock.rpc.base.RequestPacket

class ProcessPendingSeshatRefundTransactionRequest : RequestPacket() {

    var refundRequests: List<RefundRequestData> = listOf()

    override fun read(sink: InputSink) {
        super.read(sink)
        refundRequests = sink.readList()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeList(refundRequests)
    }
}