package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.IAPTransactionInfo
import moe.crx.roadblock.rpc.base.RequestPacket

class ProcessPendingSeshatIAPTransactionRequest : RequestPacket() {

    var transactionInfo: IAPTransactionInfo = IAPTransactionInfo()

    override fun read(sink: InputSink) {
        super.read(sink)
        transactionInfo = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeObject(transactionInfo)
    }
}