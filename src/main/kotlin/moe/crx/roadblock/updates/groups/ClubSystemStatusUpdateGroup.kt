package moe.crx.roadblock.updates.groups

import moe.crx.roadblock.objects.base.RVariant
import moe.crx.roadblock.updates.club.*

class ClubSystemStatusUpdateGroup : RVariant(
    ClubSystemLockedStateChanged::class,
    ClubSystemJoinedClub::class,
    ClubSystemLeftClub::class,
    ClubSystemUpdatedCachedInfo::class,
    ClubSystemSentJoinRequest::class,
    ClubSystemCancelledJoinRequest::class,
    ClubSystemSeasonEventStarted::class,
    ClubSystemSeasonEventFinished::class,
    ClubSystemJoinedSeasonEvent::class,
    ClubSystemClubReputationChanged::class,
    ClubSystemContributedReputationChanged::class,
    ClubSystemClaimedMilestones::class,
    ClubSystemClubWarsRoundRegistrationChanged::class,
    ClubSystemClubWarsLastFinishedRoundChanged::class,
    ClubSystemRemoveSeasonEvents::class,
    ClubSystemRemoveClubWarsEvents::class,
)