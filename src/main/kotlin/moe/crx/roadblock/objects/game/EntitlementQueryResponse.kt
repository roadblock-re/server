package moe.crx.roadblock.objects.game

import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class EntitlementQueryResponse : RObject {

    var transactions: List<TransactionInfo> = listOf()

    override fun read(sink: InputSink) {
        transactions = sink.readList()
    }

    override fun write(sink: OutputSink) {
        sink.writeList(transactions)
    }
}