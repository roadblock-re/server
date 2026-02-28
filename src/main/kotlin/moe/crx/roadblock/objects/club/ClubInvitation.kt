package moe.crx.roadblock.objects.club

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.ClubInvitationId
import moe.crx.roadblock.objects.social.Credentials

@Serializable
data class ClubInvitation(
    var ids: List<ClubInvitationId>,
    var club: ClubData,
    var timestamp: Instant,
    var senderCredentials: List<Credentials>,
    var senderRank: ClubMemberRank,
)
