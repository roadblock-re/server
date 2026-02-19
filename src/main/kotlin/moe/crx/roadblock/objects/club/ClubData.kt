package moe.crx.roadblock.objects.club

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.game.serialization.UntilVersion
import moe.crx.roadblock.objects.account.*

@Serializable
data class ClubData(
    var id: ClubId = "",
    var tag: ClubTag? = null,
    var name: String? = null,
    var motto: String? = null,
    var logo: ClubLogo? = null,
    var regionId: ClubRegionId? = null,
    var membershipType: ClubMembershipType? = null,
    var memberCount: UInt? = null,
    var managerCredential: Credentials? = null,
    @FromVersion("45.0.0")
    var isUGCValidated: Boolean? = null,
    @FromVersion("45.0.0")
    var lastEditor: ClubLastEditorData? = null,
    var clubSeasonEventReputations: Map<CalendarEventId, ClubSeasonEventParticipation> = mapOf(),
    var recommendationFilter: String? = null,
    @UntilVersion("45.0.0")
    var clubWarsEventParticipations: Map<CalendarEventId, ClubWarsEventParticipation> = mapOf(),
)