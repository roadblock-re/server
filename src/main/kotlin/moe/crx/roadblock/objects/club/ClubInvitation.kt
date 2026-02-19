package moe.crx.roadblock.objects.club

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.ClubInvitationId
import moe.crx.roadblock.objects.account.Credentials

@Serializable
data class ClubInvitation(
    var ids: List<ClubInvitationId>,
    var club: ClubData,
    var timestamp: Instant,
    var senderCredentials: List<Credentials>,
    var senderRank: ClubMemberRank,
)
