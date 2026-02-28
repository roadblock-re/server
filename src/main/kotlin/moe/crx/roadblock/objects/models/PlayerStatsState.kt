package moe.crx.roadblock.objects.models

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.EnumList
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.game.serialization.UntilVersion
import moe.crx.roadblock.game.serialization.enumListOf
import moe.crx.roadblock.objects.CollectorStage
import moe.crx.roadblock.objects.GarageLevel
import moe.crx.roadblock.objects.GarageValue
import moe.crx.roadblock.objects.ReputationLevel
import moe.crx.roadblock.objects.ReputationPoints
import moe.crx.roadblock.objects.playerstats.*

@Serializable
data class PlayerStatsState(
    var reputationLevel: ReputationLevel = 1u,
    var reputationPoints: ReputationPoints = 0u,
    var garageLevel: GarageLevel = 1u,
    var missions: EnumList<MissionState, MissionType> = enumListOf { MissionState() },
    var garageValue: GarageValue = 2860u, // Lancer 1* garage value
    var menuTutorials: EnumList<TutorialState, MenuTutorialType> = enumListOf { TutorialState.Pending }, // Game breaks if list has wrong size
    var gameplayTutorials: EnumList<TutorialState, GameplayTutorialType> = enumListOf { TutorialState.Pending }, // Game breaks if list has wrong size
    var tutorialOrderTracking: List<Int> = listOf(),
    @UntilVersion("24.0.0")
    var rewardForLevelUpClaimed: Boolean = true,
    @FromVersion("24.0.0")
    var lastGarageLevelWithClaimedReward: GarageLevel = 0u,
    @FromVersion("24.0.0")
    var collectorStage: CollectorStage = 0u,
    @FromVersion("24.0.0")
    var lastCollectorStageWithClaimedReward: CollectorStage = 0u,
)