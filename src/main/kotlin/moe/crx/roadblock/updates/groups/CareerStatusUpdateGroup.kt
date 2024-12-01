package moe.crx.roadblock.updates.groups

import moe.crx.roadblock.objects.base.RVariant
import moe.crx.roadblock.updates.career.*

class CareerStatusUpdateGroup : RVariant(
    CareerTotalFlagsChanged::class,
    CareerChapterStateChanged::class,
    CareerChapterFlagsChanged::class,
    CareerSeasonStateChanged::class,
    CareerSeasonFlagsChanged::class,
    CareerEventSatelliteRewardStateChanged::class,
    CareerEventStateChanged::class,
    CareerEventFlagChanged::class,
    CareerRaceFinished::class,
)