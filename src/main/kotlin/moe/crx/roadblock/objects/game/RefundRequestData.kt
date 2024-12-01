package moe.crx.roadblock.objects.game

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class RefundRequestData : RObject {

    var msgId: String = ""
    var transactionId: String = ""
    var price: String = ""

    override fun read(sink: InputSink) {
        msgId = sink.readString()
        transactionId = sink.readString()
        price = sink.readString()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(msgId)
        sink.writeString(transactionId)
        sink.writeString(price)
    }
}