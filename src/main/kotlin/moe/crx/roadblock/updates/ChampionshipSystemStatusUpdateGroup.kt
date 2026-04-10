package moe.crx.roadblock.updates

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.*
import moe.crx.roadblock.objects.championship.ChampionshipRaceMode
import moe.crx.roadblock.objects.championship.ChampionshipRoundState
import moe.crx.roadblock.objects.championship.ChampionshipStageType

@Serializable
sealed class ChampionshipSystemStatusUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<ChampionshipSystemStatusUpdateGroup> {
        override fun variants(version: SerializationVersion) = buildList {
            add(ChampionshipSystemRoundAttemptsChanged::class)
            add(ChampionshipSystemIsRegisteredChanged::class)
            add(ChampionshipSystemIsQualifiedChanged::class)
            add(ChampionshipSystemRaceFinished::class)
            add(ChampionshipSystemRaceBestTimeChanged::class)
            add(ChampionshipSystemRoundLeaderboardChanged::class)
            add(ChampionshipSystemFinalsLeaderboardChanged::class)
            add(ChampionshipSystemQualifyingRoundGroupChanged::class)
            add(ChampionshipSystemPracticeRewardsObtained::class)
            add(ChampionshipSystemFinalsGroupChanged::class)
            add(ChampionshipSystemQualifyingRoundStateChanged::class)
            add(ChampionshipSystemFinalsRoundStateChanged::class)
            add(ChampionshipSystemClaimStateChanged::class)
            add(ChampionshipSystemClaimRankReward::class)
            add(ChampionshipSystemClaimFreePack::class)
            add(ChampionshipSystemNeedsSyncServices::class)
            add(ChampionshipSystemNitroGhostResetCountChanged::class)
            add(ChampionshipSystemBestNitroGhostTimeChanged::class)
            add(ChampionshipSystemResetBestNitroGhostTime::class)
            if (version newer "24.0.0") { // TODO Find exact version
                add(ChampionshipSystemStatusUpdateGroup12::class)
            }
            add(ChampionshipSystemRemoveEvents::class)
        }
    }
}

@Serializable
data class ChampionshipSystemRoundAttemptsChanged(
    var eventId: CalendarEventId,
    var stageType: ChampionshipStageType,
    var roundId: ChampionshipRoundId,
    var attemptCount: UByte,
) : ChampionshipSystemStatusUpdateGroup()

@Serializable
data class ChampionshipSystemIsRegisteredChanged(
    var eventId: CalendarEventId,
    var roundId: ChampionshipRoundId,
) : ChampionshipSystemStatusUpdateGroup()

@Serializable
data class ChampionshipSystemIsQualifiedChanged(
    var eventId: CalendarEventId,
    var isQualified: Boolean,
    var roundId: ChampionshipRoundId,
) : ChampionshipSystemStatusUpdateGroup()

@Serializable
data class ChampionshipSystemRaceFinished(
    var eventId: CalendarEventId,
    var hasFinished: Boolean,
) : ChampionshipSystemStatusUpdateGroup()

@Serializable
data class ChampionshipSystemRaceBestTimeChanged(
    var eventId: CalendarEventId,
    var stageType: ChampionshipStageType,
    var roundId: ChampionshipRoundId,
    var raceMode: ChampionshipRaceMode,
    var timeInMicroseconds: UInt,
    var carRank: CarRank,
    @FromVersion("24.0.0")
    var isCarOverclocked: Boolean = false,
    @FromVersion("47.1.0")
    var evoTuningVisualArchetype: EvoTuningVisualArchetype? = null,
) : ChampionshipSystemStatusUpdateGroup()

@Serializable
data class ChampionshipSystemRoundLeaderboardChanged(
    var eventId: CalendarEventId,
    var stageType: ChampionshipStageType,
    var roundId: ChampionshipRoundId,
    var position: LeaderboardPosition,
    var timestamp: Instant,
) : ChampionshipSystemStatusUpdateGroup()

@Serializable
data class ChampionshipSystemFinalsLeaderboardChanged(
    var eventId: CalendarEventId,
    var position: LeaderboardPosition,
    var timestamp: Instant,
) : ChampionshipSystemStatusUpdateGroup()

@Serializable
data class ChampionshipSystemQualifyingRoundGroupChanged(
    var eventId: CalendarEventId,
    var roundId: ChampionshipRoundId,
    var groupId: ChampionshipGroupId,
) : ChampionshipSystemStatusUpdateGroup()

@Serializable
data class ChampionshipSystemPracticeRewardsObtained(
    var eventId: CalendarEventId,
    var stageType: ChampionshipStageType,
    var roundId: ChampionshipRoundId,
    var obtainedRewardIndices: List<ChampionshipRewardIndex>,
    var rewardCount: UInt,
) : ChampionshipSystemStatusUpdateGroup()

@Serializable
data class ChampionshipSystemFinalsGroupChanged(
    var eventId: CalendarEventId,
    var groupId: ChampionshipGroupId,
    var rewardsTierId: ChampionshipRewardsTierId,
) : ChampionshipSystemStatusUpdateGroup()

@Serializable
data class ChampionshipSystemQualifyingRoundStateChanged(
    var eventId: CalendarEventId,
    var roundId: ChampionshipRoundId,
    var state: ChampionshipRoundState,
) : ChampionshipSystemStatusUpdateGroup()

@Serializable
data class ChampionshipSystemFinalsRoundStateChanged(
    var eventId: CalendarEventId,
    var roundId: ChampionshipRoundId,
    var state: ChampionshipRoundState,
    var points: ChampionshipPoints,
) : ChampionshipSystemStatusUpdateGroup()

@Serializable
data class ChampionshipSystemClaimStateChanged(
    var eventId: CalendarEventId,
    var state: ChampionshipRoundState,
    var rewardIdx: UByte,
) : ChampionshipSystemStatusUpdateGroup()

@Serializable
data class ChampionshipSystemClaimRankReward(
    var eventId: CalendarEventId,
    var rewardsTierId: ChampionshipRewardsTierId,
    var rewardIdx: UByte,
) : ChampionshipSystemStatusUpdateGroup()

@Serializable
data class ChampionshipSystemClaimFreePack(
    var eventId: CalendarEventId,
    var newFreePackClaimTimePoint: Instant,
) : ChampionshipSystemStatusUpdateGroup()

@Serializable
data class ChampionshipSystemNeedsSyncServices(
    var eventId: CalendarEventId,
    var needsSync: Boolean,
) : ChampionshipSystemStatusUpdateGroup()

@Serializable
data class ChampionshipSystemBestNitroGhostTimeChanged(
    var eventId: CalendarEventId,
    var trackDefId: EventTrackDefId,
    var ghostTimeMicroseconds: UInt,
) : ChampionshipSystemStatusUpdateGroup()

@Serializable
data class ChampionshipSystemNitroGhostResetCountChanged(
    var eventId: CalendarEventId,
    var resetCount: UInt,
) : ChampionshipSystemStatusUpdateGroup()

@Serializable
data class ChampionshipSystemResetBestNitroGhostTime(
    var eventId: CalendarEventId,
    var trackDefId: EventTrackDefId,
    @FromVersion("24.0.0") // TODO Find exact version
    var ghostTimeMicroseconds: UInt = 0u,
) : ChampionshipSystemStatusUpdateGroup()

@Serializable
data class ChampionshipSystemStatusUpdateGroup12(
    var eventId: CalendarEventId,
    var trackDefId: EventTrackDefId,
) : ChampionshipSystemStatusUpdateGroup()

@Serializable
data class ChampionshipSystemRemoveEvents(
    var eventIds: List<CalendarEventId>,
) : ChampionshipSystemStatusUpdateGroup()