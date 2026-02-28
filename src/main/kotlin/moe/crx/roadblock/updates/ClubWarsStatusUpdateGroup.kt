package moe.crx.roadblock.updates

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.objects.CarRank
import moe.crx.roadblock.objects.CarUpgradeTier
import moe.crx.roadblock.objects.ClubId
import moe.crx.roadblock.objects.ClubWarsMarketProductId
import moe.crx.roadblock.objects.ClubWarsPoints
import moe.crx.roadblock.objects.ClubWarsRewardIndex
import moe.crx.roadblock.objects.ClubWarsRoundIndex
import moe.crx.roadblock.objects.GarageValue
import moe.crx.roadblock.objects.LeaderboardPosition
import moe.crx.roadblock.objects.clubwars.*
import moe.crx.roadblock.objects.social.Credentials

@Serializable
sealed class ClubWarsStatusUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<ClubWarsStatusUpdateGroup> {
        override fun variants(version: SerializationVersion) = buildList {
            add(ClubWarsRemoveEvents::class)
            add(ClubWarsLockedStateChanged::class)
            add(ClubWarsRegisterRound::class)
            add(ClubWarsUnregisterRound::class)
            add(ClubWarsRoundFinishStateChanged::class)
            add(ClubWarsRegistrationTimestampChanged::class)
            add(ClubWarsClaimRoundRewards::class)
            add(ClubWarsMatchmakingFinished::class)
            add(ClubWarsClaimStateChanged::class)
            add(ClubWarsClaimEventRewards::class)
            add(ClubWarsDefenseAttemptsChanged::class)
            add(ClubWarsNotifyOccupyNode::class)
            add(ClubWarsNotifyVacateNode::class)
            add(ClubWarsNotifyAssignCar::class)
            add(ClubWarsNotifyUnassignCar::class)
            add(ClubWarsNotifyDefenseRaceFinished::class)
            add(ClubWarsNotifyAttackRaceFinished::class)
            add(ClubWarsNotifyAttackRaceStarted::class)
            add(ClubWarsNotifyConquerNode::class)
            add(ClubWarsNotifySelectEntryPoint::class)
            add(ClubWarsNotifyResetNodes::class)
            add(ClubWarsNotifyRefreshNode::class)
            add(ClubWarsMarketLockedStateChanged::class)
            add(ClubWarsMarketStockChanged::class)
            add(ClubWarsMarketRefreshed::class)
            add(ClubWarsMarketNextRefreshTimeChanged::class)
        }
    }
}

@Serializable
data class ClubWarsClaimEventRewards(
    var eventId: CalendarEventId,
    var rewardIdx: ClubWarsRewardIndex,
) : ClubWarsStatusUpdateGroup()

@Serializable
data class ClubWarsClaimRoundRewards(
    var eventId: CalendarEventId,
    var roundId: ClubWarsRoundIndex,
    var won: Boolean,
) : ClubWarsStatusUpdateGroup()

@Serializable
data class ClubWarsClaimStateChanged(
    var eventId: CalendarEventId,
    var state: ClubWarsClaimState,
    var leaderboardPosition: LeaderboardPosition,
    var rewardIdx: ClubWarsRewardIndex,
) : ClubWarsStatusUpdateGroup()

@Serializable
data class ClubWarsDefenseAttemptsChanged(
    var eventId: CalendarEventId,
    var nodeId: ClubWarsNodeId,
    var attempts: UShort,
) : ClubWarsStatusUpdateGroup()

@Serializable
data class ClubWarsLockedStateChanged(
    var oldLockedState: Boolean,
    var newLockedState: Boolean,
) : ClubWarsStatusUpdateGroup()

@Serializable
data class ClubWarsMarketLockedStateChanged(
    var newLockedState: Boolean
) : ClubWarsStatusUpdateGroup()

@Serializable
data class ClubWarsMarketNextRefreshTimeChanged(
    var newTimePoint: Instant,
) : ClubWarsStatusUpdateGroup()

@Serializable
class ClubWarsMarketRefreshed : ClubWarsStatusUpdateGroup()

@Serializable
data class ClubWarsMarketStockChanged(
    var productId: ClubWarsMarketProductId
) : ClubWarsStatusUpdateGroup()

@Serializable
data class ClubWarsMatchmakingFinished(
    var eventId: CalendarEventId,
    var roundId: ClubWarsRoundIndex,
    var matchmakingData: ClubWarsMatchmakingData?,
) : ClubWarsStatusUpdateGroup()

@Serializable
data class ClubWarsNotifyAssignCar(
    var eventId: CalendarEventId,
    var nodeId: ClubWarsNodeId,
    var clubId: ClubId,
    var memberCredential: Credentials,
    var carId: CarId,
    var carUpgradeTier: CarUpgradeTier,
    var carRank: CarRank,
    var carGarageValue: GarageValue,
    var timestamp: Instant,
) : ClubWarsStatusUpdateGroup()

@Serializable
data class ClubWarsNotifyAttackRaceFinished(
    var eventId: CalendarEventId,
    var nodeId: ClubWarsNodeId,
    var clubId: ClubId,
    var memberCredential: Credentials,
    var carId: CarId,
    var carUpgradeTier: CarUpgradeTier,
    var carRank: CarRank,
    var carGarageValue: GarageValue,
    var raceTime: UInt,
    var timestamp: Instant,
) : ClubWarsStatusUpdateGroup()

@Serializable
data class ClubWarsNotifyAttackRaceStarted(
    var eventId: CalendarEventId,
    var nodeId: ClubWarsNodeId,
    var clubId: ClubId,
    var memberCredential: Credentials,
    var attackAttempts: UInt,
    var timestamp: Instant,
) : ClubWarsStatusUpdateGroup()

@Serializable
data class ClubWarsNotifyConquerNode(
    var eventId: CalendarEventId,
    var nodeId: ClubWarsNodeId,
    var clubId: ClubId,
    var memberCredential: Credentials,
    var timestamp: Instant,
) : ClubWarsStatusUpdateGroup()

@Serializable
data class ClubWarsNotifyDefenseRaceFinished(
    var eventId: CalendarEventId,
    var nodeId: ClubWarsNodeId,
    var clubId: ClubId,
    var memberCredential: Credentials,
    var carId: CarId,
    var carUpgradeTier: CarUpgradeTier,
    var carRank: CarRank,
    var carGarageValue: GarageValue,
    var raceTime: UInt,
    var timeImproved: Boolean,
    var timestamp: Instant,
) : ClubWarsStatusUpdateGroup()

@Serializable
data class ClubWarsNotifyOccupyNode(
    var eventId: CalendarEventId,
    var nodeId: ClubWarsNodeId,
    var clubId: ClubId,
    var memberCredential: Credentials,
    var timestamp: Instant,
) : ClubWarsStatusUpdateGroup()

@Serializable
data class ClubWarsNotifyRefreshNode(
    var eventId: CalendarEventId,
    var nodeId: ClubWarsNodeId,
    var node: ClubWarsNodeStatusUpdate,
    var timestamp: Instant,
) : ClubWarsStatusUpdateGroup()

@Serializable
data class ClubWarsNotifyResetNodes(
    var eventId: CalendarEventId,
    var nodeIds: List<ClubWarsNodeId>,
    var timestamp: Instant,
) : ClubWarsStatusUpdateGroup()

@Serializable
data class ClubWarsNotifySelectEntryPoint(
    var eventId: CalendarEventId,
    var nodeId: ClubWarsNodeId,
    var clubId: ClubId,
    var memberCredential: Credentials,
    var timestamp: Instant,
) : ClubWarsStatusUpdateGroup()

@Serializable
data class ClubWarsNotifyUnassignCar(
    var eventId: CalendarEventId,
    var nodeId: ClubWarsNodeId,
    var clubId: ClubId,
    var memberCredential: Credentials,
    var carId: CarId,
    var timestamp: Instant,
) : ClubWarsStatusUpdateGroup()

@Serializable
data class ClubWarsNotifyVacateNode(
    var eventId: CalendarEventId,
    var nodeId: ClubWarsNodeId,
    var clubId: ClubId,
    var timestamp: Instant,
) : ClubWarsStatusUpdateGroup()

@Serializable
data class ClubWarsRegisterRound(
    var eventId: CalendarEventId,
    var roundId: ClubWarsRoundIndex,
    var clubId: ClubId,
    var clanGarageValue: GarageValue,
    var clanRegistrationPoints: ClubWarsPoints,
    var isParticipant: Boolean,
    var timestamp: Instant,
) : ClubWarsStatusUpdateGroup()

@Serializable
data class ClubWarsRegistrationTimestampChanged(
    var eventId: CalendarEventId,
    var roundId: ClubWarsRoundIndex,
    var timestamp: Instant,
) : ClubWarsStatusUpdateGroup()

@Serializable
data class ClubWarsRemoveEvents(
    var eventIds: List<CalendarEventId>
) : ClubWarsStatusUpdateGroup()

@Serializable
data class ClubWarsRoundFinishStateChanged(
    var eventId: CalendarEventId,
    var roundId: ClubWarsRoundIndex,
    var finishState: ClubWarsRoundFinishState,
) : ClubWarsStatusUpdateGroup()

@Serializable
data class ClubWarsUnregisterRound(
    var eventId: CalendarEventId,
    var roundId: ClubWarsRoundIndex,
    var timestamp: Instant,
) : ClubWarsStatusUpdateGroup()