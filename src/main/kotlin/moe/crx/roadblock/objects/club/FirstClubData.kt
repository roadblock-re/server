package moe.crx.roadblock.objects.club

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.ClubId

@Serializable
data class FirstClubData(
    var id: ClubId = "",
    var eventId: CalendarEventId = "",
)