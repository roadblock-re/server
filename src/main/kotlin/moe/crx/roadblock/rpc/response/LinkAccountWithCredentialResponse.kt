package moe.crx.roadblock.rpc.response

import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.SNSUserConflictData
import moe.crx.roadblock.objects.game.UserAccountInfo
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

class LinkAccountWithCredentialResponse : UpdatesQueueWithRootReactionsResponse() {

    var isLinkingAutomaticallyCompleted: Boolean = false
    var isLinkingIgnored: Boolean = false
    var needGameRestart: Boolean = false
    var accountLinkingInfo: UserAccountInfo? = null
    var accountConflictData: SNSUserConflictData? = null

    override fun read(sink: InputSink) {
        super.read(sink)
        isLinkingAutomaticallyCompleted = sink.readBoolean()
        isLinkingIgnored = sink.readBoolean()
        needGameRestart = sink.readBoolean()
        accountLinkingInfo = sink.readOptional()
        accountConflictData = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeBoolean(isLinkingAutomaticallyCompleted)
        sink.writeBoolean(isLinkingIgnored)
        sink.writeBoolean(needGameRestart)
        sink.writeOptional(accountLinkingInfo)
        sink.writeOptional(accountConflictData)
    }
}