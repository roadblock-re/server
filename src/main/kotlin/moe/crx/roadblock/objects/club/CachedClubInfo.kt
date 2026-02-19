package moe.crx.roadblock.objects.club

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.game.serialization.UntilVersion

@Serializable
data class CachedClubInfo(
    var creationTimestamp: Instant,
    var logo: ClubLogo,
    var name: String,
    var membersCount: UInt,
    var membershipType: ClubMembershipType,
    var memberRank: ClubMemberRank,
    var motto: String,
    @FromVersion("24.0.0") @UntilVersion("45.0.0")
    var isUGCValidated: Boolean = false,
    @FromVersion("45.0.0")
    var lastEditor: ClubLastEditorData? = null,
)