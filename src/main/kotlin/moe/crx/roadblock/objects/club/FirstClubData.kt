package moe.crx.roadblock.objects.club

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.objects.account.ClubId

@Serializable
data class FirstClubData(
    var id: ClubId = "",
    var eventId: CalendarEventId = "",
)