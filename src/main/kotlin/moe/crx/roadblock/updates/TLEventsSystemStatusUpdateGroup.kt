package moe.crx.roadblock.updates

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.*
import moe.crx.roadblock.objects.tle.*

@Serializable
sealed class TLEventsSystemStatusUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<TLEventsSystemStatusUpdateGroup> {
        override fun variants(version: SerializationVersion) = buildList {
            add(TLEventsSystemLockedStateChanged::class)
            add(TLEventsSystemTicketBalanceChanged::class)
            add(TLEventsSystemSoloRewardsObtained::class)
            add(TLEventsSystemRankLeaderboardChanged::class)
            add(TLEventsSystemClaimRankDataChanged::class)
            add(TLEventsSystemClaimRankReward::class)
            add(TLEventsSystemClaimTopClubReward::class)
            add(TLEventsSystemClubRewardsCompleted::class)
            add(TLEventsSystemClubRewardClaimed::class)
            add(TLEventsSystemClaimClubDataChanged::class)
            add(TLEventsSystemBestTimeChanged::class)
            add(TLEventsSystemEnterQuarantine::class)
            add(TLEventsSystemExitQuarantine::class)
            add(TLEventsSystemQuarantineBestTimeChanged::class)
            add(TLEventsSystemRaceFinished::class)
            add(TLEventsSystemRemoveEvents::class)
            add(TLEventsSystemRemoveSpecialEvents::class)
            add(TLEventsSystemSpecialEventProgressionChanged::class)
            add(TLEventsSystemSpecialEventProgressionRewardStateChanged::class)
            add(TLEventsSystemEventAutoclaimed::class)
            add(TLEventsSystemBestNitroGhostTimeChanged::class)
            add(TLEventsSystemResetCountChanged::class)
        }
    }
}

@Serializable
data class TLEventsSystemBestNitroGhostTimeChanged(
    var eventId: TLEventId,
    var timeInMicroseconds: UInt,
    var timestamp: Instant,
) : TLEventsSystemStatusUpdateGroup()

@Serializable
data class TLEventsSystemBestTimeChanged(
    var eventId: CalendarEventId,
    var bestTimeInMicroseconds: UInt,
    var carId: CarId,
    var carRank: CarRank,
    var timestamp: Instant,
) : TLEventsSystemStatusUpdateGroup()

@Serializable
data class TLEventsSystemClaimClubDataChanged(
    var eventId: TLEventId,
    var state: ClubTLEventClaimState,
    var finalProgress: List<UByte>,
    var claimableRewards: List<UByte>,
) : TLEventsSystemStatusUpdateGroup()

@Serializable
data class TLEventsSystemClaimRankDataChanged(
    var eventId: TLEventId,
    var state: RankTLEventClaimState,
    var rankRewardIdx: UByte,
) : TLEventsSystemStatusUpdateGroup()

@Serializable
data class TLEventsSystemClaimRankReward(
    var eventId: TLEventId,
    var rewardIdx: UByte,
) : TLEventsSystemStatusUpdateGroup()

@Serializable
data class TLEventsSystemClaimTopClubReward(
    var eventId: TLEventId
) : TLEventsSystemStatusUpdateGroup()

@Serializable
data class TLEventsSystemClubRewardClaimed(
    var eventId: TLEventId,
    var rewardIdx: UByte,
) : TLEventsSystemStatusUpdateGroup()

@Serializable
data class TLEventsSystemClubRewardsCompleted(
    var eventId: TLEventId,
    var completedRewardIndices: List<TLEventsRewardIndex>
) : TLEventsSystemStatusUpdateGroup()

@Serializable
data class TLEventsSystemEnterQuarantine(
    var eventId: TLEventId,
    var rankLeaderboardName: String,
    var timestamp: Instant,
) : TLEventsSystemStatusUpdateGroup()

@Serializable
data class TLEventsSystemEventAutoclaimed(
    var eventId: TLEventId,
) : TLEventsSystemStatusUpdateGroup()

@Serializable
data class TLEventsSystemExitQuarantine(
    var eventId: TLEventId,
    var timestamp: Instant,
) : TLEventsSystemStatusUpdateGroup()

@Serializable
data class TLEventsSystemLockedStateChanged(
    var oldLockedState: Boolean,
    var newLockedState: Boolean,
) : TLEventsSystemStatusUpdateGroup()

@Serializable
data class TLEventsSystemQuarantineBestTimeChanged(
    var eventId: TLEventId,
    var bestTimeInMicroseconds: UInt,
    var carId: CarId,
    var carRank: CarRank,
    var timestamp: Instant,
) : TLEventsSystemStatusUpdateGroup()

@Serializable
data class TLEventsSystemRaceFinished(
    var eventId: TLEventId,
    var position: UByte,
    var hasFinished: Boolean,
) : TLEventsSystemStatusUpdateGroup()

@Serializable
data class TLEventsSystemRankLeaderboardChanged(
    var eventId: TLEventId,
    var position: LeaderboardPosition,
    var entryCount: UInt,
    var timestamp: Instant,
) : TLEventsSystemStatusUpdateGroup()

@Serializable
data class TLEventsSystemRemoveEvents(
    var eventIds: List<CalendarEventId>
) : TLEventsSystemStatusUpdateGroup()

@Serializable
data class TLEventsSystemRemoveSpecialEvents(
    var eventIds: List<CalendarEventId>
) : TLEventsSystemStatusUpdateGroup()

@Serializable
data class TLEventsSystemResetCountChanged(
    var eventId: TLEventId,
    var resetCount: UInt,
    var timestamp: Instant,
) : TLEventsSystemStatusUpdateGroup()

@Serializable
data class TLEventsSystemSoloRewardsObtained(
    var calendarEventId: TLEventId,
    var rewardCountPerRaceConditionIdx: List<UByte>,
    var rewardBoosts: RewardBoosts,
    var fromAutoclaim: Boolean,
) : TLEventsSystemStatusUpdateGroup()

@Serializable
data class TLEventsSystemSpecialEventProgressionChanged(
    var eventId: TLEventId,
    var progression: TimeLimitedEventProgressionLevel,
) : TLEventsSystemStatusUpdateGroup()

@Serializable
data class TLEventsSystemSpecialEventProgressionRewardStateChanged(
    var eventId: TLEventId,
    var rewardIdx: UByte,
    var newState: TimeLimitedSpecialProgressionRewardState,
) : TLEventsSystemStatusUpdateGroup()

@Serializable
data class TLEventsSystemTicketBalanceChanged(
    var oldTicketBalance: TLETicket,
    var newTicketBalance: TLETicket,
    var lastRefilledTicketTime: Instant,
    var maxTLETickets: TLETicket,
) : TLEventsSystemStatusUpdateGroup()