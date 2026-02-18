package moe.crx.roadblock.rpc.response

import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.OnlineUserData
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

class FindOnlineUserByAliasResponse : UpdatesQueueWithRootReactionsResponse() {

    var userData: OnlineUserData? = null

    override fun read(sink: InputSink) {
        super.read(sink)
        userData = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeOptional(userData)
    }
}