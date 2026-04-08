package moe.crx.roadblock.updates

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion
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
            if (version newer "45.0.0") { // TODO find exact version
                add(TLEventsSystemStatusUpdateGroup3::class)
            }
            add(TLEventsSystemRankLeaderboardChanged::class)
            add(TLEventsSystemClaimRankDataChanged::class)
            add(TLEventsSystemClaimRankReward::class)
            add(TLEventsSystemClaimTopClubReward::class)
            add(TLEventsSystemClubRewardsCompleted::class)
            add(TLEventsSystemClubRewardClaimed::class)
            add(TLEventsSystemClaimClubDataChanged::class)
            add(TLEventsSystemBestTimeChanged::class)
            if (version newer "45.0.0") { // TODO find exact version
                add(TLEventsSystemStatusUpdateGroup12::class)
            }
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
            if (version newer "45.0.0") { // TODO find exact version
                add(TLEventsSystemStatusUpdateGroup24::class)
                add(TLEventsSystemStatusUpdateGroup25::class)
                add(TLEventsSystemStatusUpdateGroup26::class)
                add(TLEventsSystemStatusUpdateGroup27::class)
                add(TLEventsSystemStatusUpdateGroup28::class)
                add(TLEventsSystemStatusUpdateGroup29::class)
            }
        }
    }
}

@Serializable
data class TLEventsSystemLockedStateChanged(
    var oldLockedState: Boolean,
    var newLockedState: Boolean,
) : TLEventsSystemStatusUpdateGroup()

@Serializable
data class TLEventsSystemTicketBalanceChanged(
    var oldTicketBalance: TLETicket,
    var newTicketBalance: TLETicket,
    var lastRefilledTicketTime: Instant,
    var maxTLETickets: TLETicket,
) : TLEventsSystemStatusUpdateGroup()

@Serializable
data class TLEventsSystemSoloRewardsObtained(
    var calendarEventId: TLEventId,
    var rewardCountPerRaceConditionIdx: List<UByte>,
    var rewardBoosts: RewardBoosts,
    var fromAutoclaim: Boolean,
) : TLEventsSystemStatusUpdateGroup()

@Serializable
data class TLEventsSystemStatusUpdateGroup3(
    var calendarEventId: TLEventId,
    var rewardIdx: UInt,
    var statRaceCondition: UByte,
    var newProgress: UInt,
) : TLEventsSystemStatusUpdateGroup()

@Serializable
data class TLEventsSystemRankLeaderboardChanged(
    var eventId: TLEventId,
    var position: LeaderboardPosition,
    var entryCount: UInt,
    var timestamp: Instant,
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
data class TLEventsSystemClubRewardsCompleted(
    var eventId: TLEventId,
    var completedRewardIndices: List<TLEventsRewardIndex>
) : TLEventsSystemStatusUpdateGroup()

@Serializable
data class TLEventsSystemClubRewardClaimed(
    var eventId: TLEventId,
    var rewardIdx: UByte,
) : TLEventsSystemStatusUpdateGroup()

@Serializable
data class TLEventsSystemClaimClubDataChanged(
    var eventId: TLEventId,
    var state: ClubTLEventClaimState,
    var finalProgress: List<UByte>,
    var claimableRewards: List<UByte>,
) : TLEventsSystemStatusUpdateGroup()

@Serializable
data class TLEventsSystemBestTimeChanged(
    var eventId: CalendarEventId,
    var bestTimeInMicroseconds: UInt,
    var carId: CarId,
    var carRank: CarRank,
    @FromVersion("24.0.0")
    var isCarOverclocked: Boolean = false,
    @FromVersion("24.6.0")
    var collectedItemCount: UInt = 0u,
    @FromVersion("24.6.0")
    var driveMeters: UInt = 0u,
    @FromVersion("47.1.0")
    var evoTuningVisualArchetype: EvoTuningVisualArchetype? = null,
    var timestamp: Instant,
) : TLEventsSystemStatusUpdateGroup()

@Serializable
data class TLEventsSystemStatusUpdateGroup12(
    var eventId: CalendarEventId,
    var timeInMicroseconds: UInt,
    var carId: CarId,
    var timestamp: Instant,
    var obtainedSoloRewardsIndices: List<UByte>,
    var maintenanceEnabled: Boolean,
) : TLEventsSystemStatusUpdateGroup()

@Serializable
data class TLEventsSystemEnterQuarantine(
    var eventId: TLEventId,
    var rankLeaderboardName: String,
    var timestamp: Instant,
) : TLEventsSystemStatusUpdateGroup()

@Serializable
data class TLEventsSystemExitQuarantine(
    var eventId: TLEventId,
    var timestamp: Instant,
) : TLEventsSystemStatusUpdateGroup()

@Serializable
data class TLEventsSystemQuarantineBestTimeChanged(
    var eventId: TLEventId,
    var bestTimeInMicroseconds: UInt,
    var carId: CarId,
    var carRank: CarRank,
    @FromVersion("24.0.0")
    var isCarOverclocked: Boolean = false,
    @FromVersion("24.6.0")
    var collectedItemCount: UInt = 0u,
    @FromVersion("24.6.0")
    var driveMeters: UInt = 0u,
    @FromVersion("47.1.0")
    var evoTuningVisualArchetype: EvoTuningVisualArchetype? = null,
    var timestamp: Instant,
) : TLEventsSystemStatusUpdateGroup()

@Serializable
data class TLEventsSystemRaceFinished(
    var eventId: TLEventId,
    var position: UByte,
    var hasFinished: Boolean,
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
data class TLEventsSystemEventAutoclaimed(
    var eventId: TLEventId,
) : TLEventsSystemStatusUpdateGroup()

@Serializable
data class TLEventsSystemBestNitroGhostTimeChanged(
    var eventId: TLEventId,
    var timeInMicroseconds: UInt,
    var timestamp: Instant,
) : TLEventsSystemStatusUpdateGroup()

@Serializable
data class TLEventsSystemResetCountChanged(
    var eventId: TLEventId,
    var resetCount: UInt,
    var timestamp: Instant,
) : TLEventsSystemStatusUpdateGroup()

@Serializable
data class TLEventsSystemStatusUpdateGroup24(
    var eventId: TLEventId,
    var optAutoplayDataChangedPayload: TLEventAutoplayData?,
) : TLEventsSystemStatusUpdateGroup()

@Serializable
data class TLEventsSystemStatusUpdateGroup25(
    var eventId: TLEventId,
    var carId: CarId,
    var optEngineId: CarEvoTuningPartId?,
) : TLEventsSystemStatusUpdateGroup()

@Serializable
data class TLEventsSystemStatusUpdateGroup26(
    var eventId: TLEventId,
    var carId: CarId,
    var optDriveTrainId: CarEvoTuningPartId?,
) : TLEventsSystemStatusUpdateGroup()

@Serializable
data class TLEventsSystemStatusUpdateGroup27(
    var eventId: TLEventId,
    var carId: CarId,
    var optIntakeId: CarEvoTuningPartId?,
) : TLEventsSystemStatusUpdateGroup()

@Serializable
data class TLEventsSystemStatusUpdateGroup28(
    var eventId: TLEventId,
    var carId: CarId,
    var optNosId: CarEvoTuningPartId?,
) : TLEventsSystemStatusUpdateGroup()

@Serializable
data class TLEventsSystemStatusUpdateGroup29(
    var eventId: TLEventId,
    var carId: CarId,
    var optSkitId: CarEvoTuningPartId?,
) : TLEventsSystemStatusUpdateGroup()