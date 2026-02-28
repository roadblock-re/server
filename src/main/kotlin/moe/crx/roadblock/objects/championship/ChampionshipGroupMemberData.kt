package moe.crx.roadblock.objects.championship

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.social.Credentials
import moe.crx.roadblock.objects.settings.RegionCode

@Serializable
data class ChampionshipGroupMemberData(
    var federationCredential: Credentials,
    var name: String?,
    var country: RegionCode?,
    var timestamp: Instant,
    var clubData: LeaderboardClubData?,
)