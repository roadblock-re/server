package moe.crx.roadblock.objects.game

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class TransactionInfo : RObject {

    var productId: AsphaltProductID = ""
    var transactionId: Long = 0

    override fun read(sink: InputSink) {
        productId = sink.readString()
        transactionId = sink.readLong()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(productId)
        sink.writeLong(transactionId)
    }

}
