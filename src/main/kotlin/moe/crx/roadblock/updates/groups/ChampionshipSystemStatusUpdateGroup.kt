package moe.crx.roadblock.updates.groups

import moe.crx.roadblock.objects.base.RVariant
import moe.crx.roadblock.updates.championship.*

class ChampionshipSystemStatusUpdateGroup : RVariant(
    ChampionshipSystemRoundAttemptsChanged::class,
    ChampionshipSystemIsRegisteredChanged::class,
    ChampionshipSystemIsQualifiedChanged::class,
    ChampionshipSystemRaceFinished::class,
    ChampionshipSystemRaceBestTimeChanged::class,
    ChampionshipSystemRoundLeaderboardChanged::class,
    ChampionshipSystemFinalsLeaderboardChanged::class,
    ChampionshipSystemQualifyingRoundGroupChanged::class,
    ChampionshipSystemPracticeRewardsObtained::class,
    ChampionshipSystemFinalsGroupChanged::class,
    ChampionshipSystemQualifyingRoundStateChanged::class,
    ChampionshipSystemFinalsRoundStateChanged::class,
    ChampionshipSystemClaimStateChanged::class,
    ChampionshipSystemClaimRankReward::class,
    ChampionshipSystemClaimFreePack::class,
    ChampionshipSystemNeedsSyncServices::class,
    ChampionshipSystemNitroGhostResetCountChanged::class,
    ChampionshipSystemBestNitroGhostTimeChanged::class,
    ChampionshipSystemResetBestNitroGhostTime::class,
    ChampionshipSystemRemoveEvents::class,
)