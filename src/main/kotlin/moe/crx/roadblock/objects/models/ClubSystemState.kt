package moe.crx.roadblock.objects.models

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.game.serialization.UntilVersion
import moe.crx.roadblock.objects.club.*
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.club.LeaveClubReason

@Serializable
data class ClubSystemState(
    var clubSeason: ClubSeason = ClubSeason(),
    var clubData: CurrentClubData? = null,
    var sentRequest: ClubSentRequestData? = null,
    var isLocked: Boolean = true,
    var firstClub: FirstClubData = FirstClubData(),
    @FromVersion("24.0.0")
    var donationData: ClubDonationData = ClubDonationData(),
    var leaveClubReason: LeaveClubReason? = null,
    var cancelJoinRequestData: Pair<CancelJoinRequestReason, String>? = null,
    @UntilVersion("45.0.0")
    var clubWars: Map<CalendarEventId, ClubWarsEventClubState> = mapOf(),
)