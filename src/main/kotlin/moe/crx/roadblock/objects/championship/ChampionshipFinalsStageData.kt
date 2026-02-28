package moe.crx.roadblock.objects.championship

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.ChampionshipGroupId
import moe.crx.roadblock.objects.ChampionshipRewardsTierId

@Serializable
data class ChampionshipFinalsStageData(
    var rounds: List<ChampionshipFinalsRoundData>,
    var groupId: ChampionshipGroupId,
    var leaderboard: ChampionshipLeaderboardData,
    var rewardsTierId: ChampionshipRewardsTierId,
)