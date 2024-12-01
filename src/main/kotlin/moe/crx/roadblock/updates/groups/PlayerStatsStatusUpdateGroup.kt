package moe.crx.roadblock.updates.groups

import moe.crx.roadblock.objects.base.RVariant
import moe.crx.roadblock.updates.playerstats.*

class PlayerStatsStatusUpdateGroup : RVariant(
    PlayerStatsReputationLevelChanged::class,
    PlayerStatsReputationPointsChanged::class,
    PlayerStatsReputationPointsOverflowed::class,
    PlayerStatsGarageLevelChanged::class,
    PlayerStatsGarageValueChanged::class,
    PlayerStatsLastGarageLevelWithClaimedRewardChanged::class,
    PlayerStatsMissionRewardClaimableChanged::class,
    PlayerStatsMissionValueChanged::class,
    PlayerStatsMissionMilestoneChanged::class,
    PlayerStatsMenuTutorialStateChanged::class,
    PlayerStatsGameplayTutorialStateChanged::class,
)