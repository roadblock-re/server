package moe.crx.roadblock.rpc.response

import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.ChampionshipGroupMemberData
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

class ChampionshipSpecialEventRefreshFinalsGroupResponse : UpdatesQueueWithRootReactionsResponse() {

    var members: List<ChampionshipGroupMemberData> = listOf()

    override fun read(sink: InputSink) {
        super.read(sink)
        members = sink.readList()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeList(members)
    }
}