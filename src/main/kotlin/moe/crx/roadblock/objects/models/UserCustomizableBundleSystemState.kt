package moe.crx.roadblock.objects.models

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.ucbundle.UserCustomizableBundleEvent

@Serializable
data class UserCustomizableBundleSystemState(
    var eventDataById: Map<CalendarEventId, UserCustomizableBundleEvent> = mapOf(),
)