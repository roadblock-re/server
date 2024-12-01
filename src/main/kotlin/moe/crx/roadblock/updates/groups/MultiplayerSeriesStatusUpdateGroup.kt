package moe.crx.roadblock.updates.groups

import moe.crx.roadblock.objects.base.RVariant
import moe.crx.roadblock.updates.multiplayer.*

class MultiplayerSeriesStatusUpdateGroup : RVariant(
    MultiplayerSeriesLockedStateChanged::class,
    MultiplayerSeriesEventJoined::class,
    MultiplayerSeriesEventClaimable::class,
    MultiplayerSeriesEventClaimed::class,
    MultiplayerSeriesClaimRankRewards::class,
    MultiplayerSeriesCurrentEventReset::class,
    MultiplayerSeriesEloChanged::class,
    MultiplayerSeriesLeaderboardDataChanged::class,
    MultiplayerSeriesRacesCountChanged::class,
    MultiplayerSeriesCurrentTierChanged::class,
    MultiplayerSeriesMaxTierChanged::class,
    MultiplayerSeriesLeaderboardNameChanged::class,
    MultiplayerSeriesMostRecentDisconnectionsChanged::class,
    MultiplayerSeriesRaceFinished::class,
    MultiplayerSeriesRemoveEvents::class,
    MultiplayerSeriesScoreChanged::class,
    MultiplayerSeriesMilestoneChanged::class,
)