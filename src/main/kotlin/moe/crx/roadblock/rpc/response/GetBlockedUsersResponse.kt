package moe.crx.roadblock.rpc.response

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.OnlineUserData
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

class GetBlockedUsersResponse : UpdatesQueueWithRootReactionsResponse() {

    var blockedUsers: List<OnlineUserData> = listOf()

    override fun read(sink: InputSink) {
        super.read(sink)
        blockedUsers = sink.readList()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeList(blockedUsers)
    }
}