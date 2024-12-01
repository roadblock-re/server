package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.rpc.base.RequestPacket

class ProcessPendingSeshatGiftTransactionRequest : RequestPacket() {

    var pointcutId: String = ""
    var pointcutArguments: String = ""
    var campaignId: String = ""

    override fun read(sink: InputSink) {
        super.read(sink)
        pointcutId = sink.readString()
        pointcutArguments = sink.readString()
        campaignId = sink.readString()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(pointcutId)
        sink.writeString(pointcutArguments)
        sink.writeString(campaignId)
    }
}