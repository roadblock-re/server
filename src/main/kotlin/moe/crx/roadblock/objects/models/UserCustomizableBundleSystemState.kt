package moe.crx.roadblock.objects.models

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.objects.account.UserCustomizableBundleEvent

@Serializable
data class UserCustomizableBundleSystemState(
    var eventDataById: Map<CalendarEventId, UserCustomizableBundleEvent> = mapOf(),
)