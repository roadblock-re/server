package moe.crx.roadblock.updates.groups

import moe.crx.roadblock.objects.base.RVariant
import moe.crx.roadblock.updates.seasonpass.*

class SeasonPassSystemStatusUpdateGroup : RVariant(
    SeasonPassSystemSeasonPassStarted::class,
    SeasonPassSystemSeasonPassFinished::class,
    SeasonPassSystemSeasonPassEndDateModified::class,
    SeasonPassSystemLegendPassStateChanged::class,
    SeasonPassSystemMissionQuantityChanged::class,
    SeasonPassSystemMissionStateChanged::class,
    SeasonPassSystemExperienceChanged::class,
    SeasonPassSystemBoostChanged::class,
    SeasonPassSystemExtraMaintenanceSlotsChanged::class,
    SeasonPassSystemBenefitNextAvailableTLERefillChanged::class,
    SeasonPassSystemTierRewardStateChanged::class,
    SeasonPassSystemEpisodePartialCompletionRewardStateChanged::class,
    SeasonPassSystemEpisodesCompletionRewardStateChanged::class,
    SeasonPassSystemNextSeasonDiscountPurchasedChanged::class,
    SeasonPassSystemRemoveEvents::class,
    SeasonPassSystemNotifyClaimTierRewards::class,
    SeasonPassSystemPlayedOnboardingChanged::class,
)