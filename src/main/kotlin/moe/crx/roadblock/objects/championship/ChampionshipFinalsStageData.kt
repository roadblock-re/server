package moe.crx.roadblock.objects.championship

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.ChampionshipGroupId
import moe.crx.roadblock.objects.game.ChampionshipRewardsTierId

class ChampionshipFinalsStageData : RObject {

    var rounds: List<ChampionshipFinalsRoundData> = listOf()
    var groupId: ChampionshipGroupId = 0
    var leaderboard: ChampionshipLeaderboardData = ChampionshipLeaderboardData()
    var rewardsTierId: ChampionshipRewardsTierId = 0

    override fun read(sink: InputSink) {
        rounds = sink.readList()
        groupId = sink.readInt()
        leaderboard = sink.readObject()
        rewardsTierId = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeList(rounds)
        sink.writeInt(groupId)
        sink.writeObject(leaderboard)
        sink.writeInt(rewardsTierId)
    }
}