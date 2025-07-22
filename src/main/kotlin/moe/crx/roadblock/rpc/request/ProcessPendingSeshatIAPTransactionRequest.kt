package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.IAPTransactionInfo
import moe.crx.roadblock.objects.game.TransactionInfo
import moe.crx.roadblock.rpc.base.RequestPacket

class ProcessPendingSeshatIAPTransactionRequest : RequestPacket() {

    var transactionInfo: IAPTransactionInfo? = null
    var entitlementQueryResponse: TransactionInfo? = null

    override fun read(sink: InputSink) {
        super.read(sink)
        transactionInfo = if (sink older "45.0.0") {
            sink.readObject()
        } else {
            sink.readOptional()
        }
        if (sink newer "45.0.0") {
            entitlementQueryResponse = sink.readOptional()
        }
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        if (sink older "45.0.0") {
            sink.writeObject(transactionInfo ?: IAPTransactionInfo())
        } else {
            sink.writeOptional(transactionInfo)
        }
        if (sink newer "45.0.0") {
            sink.writeOptional(entitlementQueryResponse)
        }
    }
}