package moe.crx.roadblock.objects.inventory

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.CarId
import moe.crx.roadblock.objects.account.MaintenanceSlots

@Serializable
data class MaintenanceBooking(
    var carId: CarId,
    var numberOfSlots: MaintenanceSlots,
)