package moe.crx.roadblock.updates

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.*
import moe.crx.roadblock.objects.club.CachedClubInfo
import moe.crx.roadblock.objects.club.CancelJoinRequestReason
import moe.crx.roadblock.objects.club.ClubMemberRank
import moe.crx.roadblock.objects.club.LeaveClubReason
import moe.crx.roadblock.objects.social.Credentials

@Serializable
sealed class ClubSystemStatusUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<ClubSystemStatusUpdateGroup> {
        override fun variants(version: SerializationVersion) = buildList {
            add(ClubSystemLockedStateChanged::class)
            add(ClubSystemJoinedClub::class)
            add(ClubSystemLeftClub::class)
            add(ClubSystemUpdatedCachedInfo::class)
            add(ClubSystemSentJoinRequest::class)
            add(ClubSystemCancelledJoinRequest::class)
            add(ClubSystemSeasonEventStarted::class)
            add(ClubSystemSeasonEventFinished::class)
            add(ClubSystemJoinedSeasonEvent::class)
            add(ClubSystemClubReputationChanged::class)
            add(ClubSystemContributedReputationChanged::class)
            add(ClubSystemClaimedMilestones::class)
            if (version older "45.0.0") {
                add(ClubSystemClubWarsRoundRegistrationChanged::class)
                add(ClubSystemClubWarsLastFinishedRoundChanged::class)
            }
            add(ClubSystemRemoveSeasonEvents::class)
            if (version older "45.0.0") {
                add(ClubSystemRemoveClubWarsEvents::class)
            }
            add(ClubSystemStatusUpdateGroup13::class) // TODO name
            add(ClubSystemStatusUpdateGroup14::class) // TODO name
            add(ClubSystemStatusUpdateGroup15::class) // TODO name
            add(ClubSystemStatusUpdateGroup16::class) // TODO name
        }
    }
}

@Serializable
data class ClubSystemLockedStateChanged(
    var oldLockedState: Boolean,
    var newLockedState: Boolean,
) : ClubSystemStatusUpdateGroup()

@Serializable
data class ClubSystemJoinedClub(
    var id: ClubId,
    var reputation: ReputationPoints,
    var rank: ClubMemberRank,
) : ClubSystemStatusUpdateGroup()

@Serializable
data class ClubSystemLeftClub(
    var id: ClubId,
    var reason: LeaveClubReason,
) : ClubSystemStatusUpdateGroup()

@Serializable
data class ClubSystemUpdatedCachedInfo(
    var clubInfo: CachedClubInfo,
) : ClubSystemStatusUpdateGroup()

@Serializable
data class ClubSystemSentJoinRequest(
    var id: ClubRequestId,
    var clubId: ClubId,
    var clubName: String,
) : ClubSystemStatusUpdateGroup()

@Serializable
data class ClubSystemCancelledJoinRequest(
    var id: ClubRequestId,
    var reason: CancelJoinRequestReason,
    var clubName: String,
) : ClubSystemStatusUpdateGroup()

@Serializable
data class ClubSystemSeasonEventStarted(
    var id: CalendarEventId
) : ClubSystemStatusUpdateGroup()

@Serializable
data class ClubSystemSeasonEventFinished(
    var id: CalendarEventId,
    var canClaimMilestones: Boolean,
) : ClubSystemStatusUpdateGroup()

@Serializable
data class ClubSystemJoinedSeasonEvent(
    var id: CalendarEventId
) : ClubSystemStatusUpdateGroup()

@Serializable
data class ClubSystemClubReputationChanged(
    var reputation: ReputationPoints
) : ClubSystemStatusUpdateGroup()

@Serializable
data class ClubSystemContributedReputationChanged(
    var reputation: ReputationPoints
) : ClubSystemStatusUpdateGroup()

@Serializable
data class ClubSystemClaimedMilestones(
    var eventId: CalendarEventId,
    var milestoneIds: List<ClubSeasonMilestoneId>,
) : ClubSystemStatusUpdateGroup()

@Serializable
data class ClubSystemClubWarsRoundRegistrationChanged(
    var eventId: CalendarEventId,
    var oldRegisteredRound: ClubWarsRoundIndex,
    var newRegisteredRound: ClubWarsRoundIndex,
    var newRegisteredTimestamp: Instant,
) : ClubSystemStatusUpdateGroup()

@Serializable
data class ClubSystemClubWarsLastFinishedRoundChanged(
    var eventId: CalendarEventId,
    var lastFinishedRoundIndex: ClubWarsRoundIndex,
    var eventScoreAfterLastFinishedRound: ClubWarsPoints,
) : ClubSystemStatusUpdateGroup()

@Serializable
data class ClubSystemRemoveSeasonEvents(
    var eventIds: List<CalendarEventId>
) : ClubSystemStatusUpdateGroup()

@Serializable
data class ClubSystemRemoveClubWarsEvents(
    var eventIds: List<CalendarEventId>
) : ClubSystemStatusUpdateGroup()

@Serializable
data class ClubSystemStatusUpdateGroup13(
    var templateId: String,
    var itemId: ClubDonationItemId,
    var amount: UInt,
    var timestamp: Instant,
) : ClubSystemStatusUpdateGroup()

@Serializable
data class ClubSystemStatusUpdateGroup14(
    var templateId: String?,
    var itemId: ClubDonationItemId,
    var timestamp: Instant,
) : ClubSystemStatusUpdateGroup()

@Serializable
data class ClubSystemStatusUpdateGroup15(
    var templateId: String,
    var requester: Credentials,
    var reason: UInt,
    var timestamp: Instant,
) : ClubSystemStatusUpdateGroup()

@Serializable
data class ClubSystemStatusUpdateGroup16(
    var templateId: String,
    var itemId: ClubDonationItemId,
    var amount: UInt,
    var requester: Credentials,
    var timestamp: Instant,
    var donationResult: UInt,
) : ClubSystemStatusUpdateGroup()