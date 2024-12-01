package moe.crx.roadblock.updates.groups

import moe.crx.roadblock.objects.base.RVariant
import moe.crx.roadblock.updates.uber.*

class UberSystemStatusUpdateGroup : RVariant(
    UberSystemEventParticipated::class,
    UberSystemMissionCompleted::class,
    UberSystemExperienceChanged::class,
    UberSystemHazardLevelChanged::class,
    UberSystemtimesPurchasedForSlotChanged::class,
    UberSystemRemoveEvents::class,
    UberSystemRaceFinished::class,
    UberSystemCarDiscovered::class,
    UberSystemRaceReward::class,
    UberSystemCurrencyBeenConvertedChanged::class,
    UberSystemMilestoneAchieved::class,
    UberSystemUberExperienceObtainedInMissionsChanged::class,
    UberSystemUberCurrencyObtainedInPinnedMissionChanged::class,
)