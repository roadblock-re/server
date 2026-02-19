package moe.crx.roadblock.objects.tracking

import kotlinx.serialization.Serializable

@Serializable
data class ClientTrackingEvents(
    var events: List<TrackingEvent>,
)