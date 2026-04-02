package moe.crx.roadblock.objects.inventory

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.MaintenanceSlots

@Serializable
data class CarMaintenanceState(
    var slots: MaintenanceSlots,
    var isRefilling: Boolean = false,
    var refillEndTime: Instant = now(),
    var slotsBeforeRefilling: MaintenanceSlots = slots,
)