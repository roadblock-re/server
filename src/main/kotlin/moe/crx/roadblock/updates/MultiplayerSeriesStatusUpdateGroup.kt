package moe.crx.roadblock.updates

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.*
import moe.crx.roadblock.objects.*
import moe.crx.roadblock.objects.multiplayer.*

@Serializable
sealed class MultiplayerSeriesStatusUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<MultiplayerSeriesStatusUpdateGroup> {
        override fun variants(version: SerializationVersion) = buildList {
            add(MultiplayerSeriesLockedStateChanged::class)
            add(MultiplayerSeriesEventJoined::class)
            add(MultiplayerSeriesEventClaimable::class)
            add(MultiplayerSeriesEventClaimed::class)
            add(MultiplayerSeriesClaimRankRewards::class)
            add(MultiplayerSeriesCurrentEventReset::class)
            add(MultiplayerSeriesEloChanged::class)
            add(MultiplayerSeriesLeaderboardDataChanged::class)
            add(MultiplayerSeriesRacesCountChanged::class)
            add(MultiplayerSeriesCurrentTierChanged::class)
            add(MultiplayerSeriesMaxTierChanged::class)
            add(MultiplayerSeriesLeaderboardNameChanged::class)
            add(MultiplayerSeriesMostRecentDisconnectionsChanged::class)
            add(MultiplayerSeriesRaceFinished::class)
            add(MultiplayerSeriesRemoveEvents::class)
            add(MultiplayerSeriesScoreChanged::class)
            if (version newer "45.0.0") { // TODO find exact version
                add(MultiplayerSeriesStatusUpdateGroup16::class)
            }
            add(MultiplayerSeriesMilestoneChanged::class)
            if (version newer "45.0.0") { // TODO find exact version
                add(MultiplayerSeriesStatusUpdateGroup18::class)
                add(MultiplayerSeriesStatusUpdateGroup19::class)
                add(MultiplayerSeriesStatusUpdateGroup20::class)
                add(MultiplayerSeriesStatusUpdateGroup21::class)
                add(MultiplayerSeriesStatusUpdateGroup22::class)
            }
        }
    }
}

@Serializable
data class MultiplayerSeriesLockedStateChanged(
    var oldLockedState: Boolean,
    var newLockedState: Boolean,
) : MultiplayerSeriesStatusUpdateGroup()

@Serializable
data class MultiplayerSeriesEventJoined(
    var seriesId: MultiplayerSeriesId,
    var eventId: CalendarEventId,
    var enterElo: PlayerElo,
    var enterTier: MultiplayerSeriesTierInfo,
) : MultiplayerSeriesStatusUpdateGroup()

@Serializable
data class MultiplayerSeriesEventClaimable(
    var seriesId: MultiplayerSeriesId,
    var eventId: CalendarEventId,
) : MultiplayerSeriesStatusUpdateGroup()

@Serializable
data class MultiplayerSeriesEventClaimed(
    var seriesId: MultiplayerSeriesId,
    var eventId: CalendarEventId,
    var eloForNextEvent: PlayerElo,
    @FromVersion("45.0.0") // TODO find exact version
    var timepoint: Instant,
) : MultiplayerSeriesStatusUpdateGroup()

@Serializable
data class MultiplayerSeriesClaimRankRewards(
    var seriesId: MultiplayerSeriesId,
    var eventId: CalendarEventId,
    var position: LeaderboardPosition,
) : MultiplayerSeriesStatusUpdateGroup()

@Serializable
data class MultiplayerSeriesCurrentEventReset(
    var seriesId: MultiplayerSeriesId
) : MultiplayerSeriesStatusUpdateGroup()

@Serializable
data class MultiplayerSeriesEloChanged(
    var eventId: CalendarEventId,
    var oldElo: PlayerElo,
    var newElo: PlayerElo,
) : MultiplayerSeriesStatusUpdateGroup()

@Serializable
data class MultiplayerSeriesLeaderboardDataChanged(
    var eventId: CalendarEventId,
    var oldLeaderboardData: MultiplayerSeriesLeaderboardData?,
    var newLeaderboardData: MultiplayerSeriesLeaderboardData,
) : MultiplayerSeriesStatusUpdateGroup()

@Serializable
data class MultiplayerSeriesRacesCountChanged(
    var eventId: CalendarEventId,
    var oldCount: Int,
    var newCount: Int,
) : MultiplayerSeriesStatusUpdateGroup()

@Serializable
data class MultiplayerSeriesCurrentTierChanged(
    var eventId: CalendarEventId,
    var oldTier: MultiplayerSeriesTierInfo,
    var newTier: MultiplayerSeriesTierInfo,
) : MultiplayerSeriesStatusUpdateGroup()

@Serializable
data class MultiplayerSeriesMaxTierChanged(
    var eventId: CalendarEventId,
    var oldTier: MultiplayerSeriesTierInfo,
    var newTier: MultiplayerSeriesTierInfo,
) : MultiplayerSeriesStatusUpdateGroup()

@Serializable
data class MultiplayerSeriesLeaderboardNameChanged(
    var eventId: CalendarEventId,
    var oldLeaderboardName: String?,
    var newLeaderboardName: String?,
) : MultiplayerSeriesStatusUpdateGroup()

@Serializable
data class MultiplayerSeriesMostRecentDisconnectionsChanged(
    var oldDisconnections: List<Instant>,
    var newDisconnections: List<Instant>,
) : MultiplayerSeriesStatusUpdateGroup()

@Serializable
data class MultiplayerSeriesRaceFinished(
    var raceResult: MultiplayerSeriesRaceResult
) : MultiplayerSeriesStatusUpdateGroup()

@Serializable
data class MultiplayerSeriesRemoveEvents(
    var eventIds: List<CalendarEventId>
) : MultiplayerSeriesStatusUpdateGroup()

@Serializable
data class MultiplayerSeriesScoreChanged(
    var eventId: CalendarEventId,
    var oldMultiplayerSeriesScore: MultiplayerSeriesScore,
    var newMultiplayerSeriesScore: MultiplayerSeriesScore,
    @FromVersion("45.0.0") // TODO find exact version
    var baseScore: UInt,
    @FromVersion("45.0.0") // TODO find exact version
    var bonusScore: UInt,
) : MultiplayerSeriesStatusUpdateGroup()

@Serializable
data class MultiplayerSeriesStatusUpdateGroup16(
    var eventId: CalendarEventId,
    var peakScore: UInt,
) : MultiplayerSeriesStatusUpdateGroup()

@Serializable
data class MultiplayerSeriesMilestoneChanged(
    var eventId: CalendarEventId,
    var milestoneId: MultiplayerSeriesScoreMilestoneId,
    @ByteEnum @UntilVersion("45.0.0") // TODO find exact version
    var state: MultiplayerSeriesScoreMilestoneRewardState,
    var isBonusPassExclusive: Boolean,
) : MultiplayerSeriesStatusUpdateGroup()

@Serializable
data class MultiplayerSeriesStatusUpdateGroup18(
    var eventId: CalendarEventId,
    var milestoneId: MultiplayerSeriesScoreMilestoneId,
) : MultiplayerSeriesStatusUpdateGroup()

@Serializable
data class MultiplayerSeriesStatusUpdateGroup19(
    var eventId: CalendarEventId,
) : MultiplayerSeriesStatusUpdateGroup()

@Serializable
data class MultiplayerSeriesStatusUpdateGroup20(
    var triumphReward: TriumphReward
) : MultiplayerSeriesStatusUpdateGroup()

@Serializable
data class MultiplayerSeriesStatusUpdateGroup21(
    var triumphReward: TriumphReward
) : MultiplayerSeriesStatusUpdateGroup()

@Serializable
data class MultiplayerSeriesStatusUpdateGroup22(
    var triumphRewards: List<TriumphReward>
) : MultiplayerSeriesStatusUpdateGroup()