package moe.crx.roadblock.objects.game

import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RByte
import moe.crx.roadblock.objects.base.RObject

class TransactionInfo : RObject {

    var productId: AsphaltProductID = ""
    var transactionId: Long = 0
    var gamePassPerk: RByte? = null

    override fun read(sink: InputSink) {
        productId = sink.readString()
        transactionId = sink.readLong()
        if (sink newer "45.0.0") {
            gamePassPerk = sink.readOptional()
        }
    }

    override fun write(sink: OutputSink) {
        sink.writeString(productId)
        sink.writeLong(transactionId)
        if (sink newer "45.0.0") {
            sink.writeOptional(gamePassPerk)
        }
    }

}
