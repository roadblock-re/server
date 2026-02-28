package moe.crx.roadblock.objects.party

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.game.serialization.UntilVersion
import moe.crx.roadblock.objects.ClubId
import moe.crx.roadblock.objects.club.ClubLogo

@Serializable
data class MultiplayerUserClubData(
    var timestamp: Instant,
    var id: ClubId,
    var logo: ClubLogo,
    var name: String,
    @FromVersion("24.0.0") @UntilVersion("45.0.0")
    var isUGCValidated: Boolean = false,
    @FromVersion("45.0.0")
    var lastEditor: MultiplayerUserClubDataLastEditor? = null,
)