package moe.crx.roadblock.objects.models

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.party.PrivateLobbyEventData

@Serializable
data class PrivateLobbyState(
    var eventById: Map<CalendarEventId, PrivateLobbyEventData> = mapOf(),
)