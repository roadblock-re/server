package moe.crx.roadblock.updates.groups

import moe.crx.roadblock.objects.base.RVariant
import moe.crx.roadblock.updates.tle.*

class TLEventsSystemStatusUpdateGroup : RVariant(
    TLEventsSystemLockedStateChanged::class,
    TLEventsSystemTicketBalanceChanged::class,
    TLEventsSystemSoloRewardsObtained::class,
    TLEventsSystemRankLeaderboardChanged::class,
    TLEventsSystemClaimRankDataChanged::class,
    TLEventsSystemClaimRankReward::class,
    TLEventsSystemClaimTopClubReward::class,
    TLEventsSystemClubRewardsCompleted::class,
    TLEventsSystemClubRewardClaimed::class,
    TLEventsSystemClaimClubDataChanged::class,
    TLEventsSystemBestTimeChanged::class,
    TLEventsSystemEnterQuarantine::class,
    TLEventsSystemExitQuarantine::class,
    TLEventsSystemQuarantineBestTimeChanged::class,
    TLEventsSystemRaceFinished::class,
    TLEventsSystemRemoveEvents::class,
    TLEventsSystemRemoveSpecialEvents::class,
    TLEventsSystemSpecialEventProgressionChanged::class,
    TLEventsSystemSpecialEventProgressionRewardStateChanged::class,
    TLEventsSystemEventAutoclaimed::class,
    TLEventsSystemBestNitroGhostTimeChanged::class,
    TLEventsSystemResetCountChanged::class,
)