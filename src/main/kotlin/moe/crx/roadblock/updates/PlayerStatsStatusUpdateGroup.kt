package moe.crx.roadblock.updates

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.*
import moe.crx.roadblock.objects.playerstats.GameplayTutorialType
import moe.crx.roadblock.objects.playerstats.MenuTutorialType
import moe.crx.roadblock.objects.playerstats.MissionType
import moe.crx.roadblock.objects.playerstats.TutorialState

@Serializable
sealed class PlayerStatsStatusUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<PlayerStatsStatusUpdateGroup> {
        override fun variants(version: SerializationVersion) = buildList {
            add(PlayerStatsReputationLevelChanged::class)
            add(PlayerStatsReputationPointsChanged::class)
            add(PlayerStatsReputationPointsOverflowed::class)
            add(PlayerStatsGarageLevelChanged::class)
            add(PlayerStatsGarageValueChanged::class)
            if (version newer "45.0.0") { // TODO find exact version
                add(PlayerStatsStatusUpdateGroup5::class)
            }
            add(PlayerStatsLastGarageLevelWithClaimedRewardChanged::class)
            if (version newer "45.0.0") { // TODO find exact version
                add(PlayerStatsStatusUpdateGroup7::class)
            }
            add(PlayerStatsMissionRewardClaimableChanged::class)
            if (version newer "45.0.0") { // TODO find exact version
                add(PlayerStatsStatusUpdateGroup9::class)
            }
            add(PlayerStatsMissionValueChanged::class)
            if (version newer "45.0.0") { // TODO find exact version
                add(PlayerStatsStatusUpdateGroup11::class)
            }
            add(PlayerStatsMissionMilestoneChanged::class)
            add(PlayerStatsMenuTutorialStateChanged::class)
            add(PlayerStatsGameplayTutorialStateChanged::class)
        }
    }
}

@Serializable
data class PlayerStatsReputationLevelChanged(
    var oldLevel: ReputationLevel,
    var newLevel: ReputationLevel,
) : PlayerStatsStatusUpdateGroup()

@Serializable
data class PlayerStatsReputationPointsChanged(
    var oldPoints: ReputationPoints,
    var newPoints: ReputationPoints,
    var seasonPassBonusPoints: ReputationPoints?,
) : PlayerStatsStatusUpdateGroup()

@Serializable
data class PlayerStatsReputationPointsOverflowed(
    var leftover: ReputationPoints,
) : PlayerStatsStatusUpdateGroup()

@Serializable
data class PlayerStatsGarageLevelChanged(
    var oldLevel: ReputationLevel,
    var newLevel: ReputationLevel,
) : PlayerStatsStatusUpdateGroup()

@Serializable
data class PlayerStatsGarageValueChanged(
    var oldValue: GarageValue,
    var newValue: GarageValue,
) : PlayerStatsStatusUpdateGroup()

@Serializable
data class PlayerStatsStatusUpdateGroup5(
    var oldState: CollectorStage,
    var newState: CollectorStage,
) : PlayerStatsStatusUpdateGroup()

@Serializable
data class PlayerStatsLastGarageLevelWithClaimedRewardChanged(
    var oldLevel: GarageLevel,
    var newLevel: GarageLevel,
) : PlayerStatsStatusUpdateGroup()

@Serializable
data class PlayerStatsStatusUpdateGroup7(
    var oldState: CollectorStage,
    var newState: CollectorStage,
) : PlayerStatsStatusUpdateGroup()

@Serializable
data class PlayerStatsMissionRewardClaimableChanged(
    var mission: MissionType,
    var claimable: Boolean,
) : PlayerStatsStatusUpdateGroup()

@Serializable
data class PlayerStatsStatusUpdateGroup9(
    var mission: MissionType,
    var milestone: MissionMilestone,
) : PlayerStatsStatusUpdateGroup()

@Serializable
data class PlayerStatsMissionValueChanged(
    var mission: MissionType,
    var oldValue: MissionValue,
    var newValue: MissionValue,
) : PlayerStatsStatusUpdateGroup()

@Serializable
data class PlayerStatsStatusUpdateGroup11(
    var mission: MissionType,
    var currentValue: UInt,
) : PlayerStatsStatusUpdateGroup()

@Serializable
data class PlayerStatsMissionMilestoneChanged(
    var mission: MissionType,
    var oldMilestone: MissionMilestone,
    var newMilestone: MissionMilestone,
) : PlayerStatsStatusUpdateGroup()

@Serializable
data class PlayerStatsMenuTutorialStateChanged(
    var type: MenuTutorialType,
    var oldState: TutorialState,
    var newState: TutorialState,
) : PlayerStatsStatusUpdateGroup()

@Serializable
data class PlayerStatsGameplayTutorialStateChanged(
    var type: GameplayTutorialType,
    var oldState: TutorialState,
    var newState: TutorialState,
) : PlayerStatsStatusUpdateGroup()