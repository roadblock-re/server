package moe.crx.roadblock.updates.groups

import moe.crx.roadblock.objects.base.RVariant
import moe.crx.roadblock.updates.clubwars.*

class ClubWarsStatusUpdateGroup : RVariant(
    ClubWarsRemoveEvents::class,
    ClubWarsLockedStateChanged::class,
    ClubWarsRegisterRound::class,
    ClubWarsUnregisterRound::class,
    ClubWarsRoundFinishStateChanged::class,
    ClubWarsRegistrationTimestampChanged::class,
    ClubWarsClaimRoundRewards::class,
    ClubWarsMatchmakingFinished::class,
    ClubWarsClaimStateChanged::class,
    ClubWarsClaimEventRewards::class,
    ClubWarsDefenseAttemptsChanged::class,
    ClubWarsNotifyOccupyNode::class,
    ClubWarsNotifyVacateNode::class,
    ClubWarsNotifyAssignCar::class,
    ClubWarsNotifyUnassignCar::class,
    ClubWarsNotifyDefenseRaceFinished::class,
    ClubWarsNotifyAttackRaceFinished::class,
    ClubWarsNotifyAttackRaceStarted::class,
    ClubWarsNotifyConquerNode::class,
    ClubWarsNotifySelectEntryPoint::class,
    ClubWarsNotifyResetNodes::class,
    ClubWarsNotifyRefreshNode::class,
    ClubWarsMarketLockedStateChanged::class,
    ClubWarsMarketStockChanged::class,
    ClubWarsMarketRefreshed::class,
    ClubWarsMarketNextRefreshTimeChanged::class,
)