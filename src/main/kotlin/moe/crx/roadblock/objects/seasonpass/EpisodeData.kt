package moe.crx.roadblock.objects.seasonpass

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.ByteEnum
import moe.crx.roadblock.objects.account.SeasonPassMissionId

@Serializable
data class EpisodeData(
    var missions: Map<SeasonPassMissionId, MissionData>,
    @ByteEnum
    var partiallyCompletedRewardState: SeasonPassEpisodePartialCompletionRewardState,
)