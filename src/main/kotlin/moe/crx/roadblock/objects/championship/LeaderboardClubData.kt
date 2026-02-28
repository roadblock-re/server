package moe.crx.roadblock.objects.championship

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.game.serialization.UntilVersion
import moe.crx.roadblock.objects.ClubId
import moe.crx.roadblock.objects.club.ClubLogo

@Serializable
data class LeaderboardClubData(
    var id: ClubId,
    var timestamp: Instant,
    var name: String,
    var logo: ClubLogo,
    @UntilVersion("47.1.0")
    var isUGCValidated: Boolean? = null,
    @FromVersion("47.1.0")
    var lastEditor: LastEditorData? = null,
)