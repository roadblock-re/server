package moe.crx.roadblock.objects.seasonpass

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.ByteEnum
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.objects.SeasonPassEpisodeId
import moe.crx.roadblock.objects.SeasonPassId
import moe.crx.roadblock.objects.SeasonPassTierId

@Serializable
data class SeasonPassState(
    var endDate: Instant,
    var seasonPassId: SeasonPassId,
    var episodes: Map<SeasonPassEpisodeId, EpisodeData>,
    var tiers: Map<SeasonPassTierId, TierData>,
    var benefits: LegendPassBenefitsMultipliers,
    @FromVersion("3.7.0")
    var nextDayFromLastRace: Instant = now(),
    @FromVersion("24.6.0") @ByteEnum
    var episodesCompletionRewardsState: SeasonPassEpisodesCompletionRewardState = SeasonPassEpisodesCompletionRewardState.Locked,
)