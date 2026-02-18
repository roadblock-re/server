package moe.crx.roadblock.rpc.response

import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.UserAccountInfo
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

class ConfirmLinkingOperationResponse : UpdatesQueueWithRootReactionsResponse() {

    var needGameRestart: Boolean = false
    var accountLinkingInfo: UserAccountInfo = UserAccountInfo()

    override fun read(sink: InputSink) {
        super.read(sink)
        needGameRestart = sink.readBoolean()
        accountLinkingInfo = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeBoolean(needGameRestart)
        sink.writeObject(accountLinkingInfo)
    }
}