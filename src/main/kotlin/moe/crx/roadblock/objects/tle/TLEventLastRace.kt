package moe.crx.roadblock.objects.tle

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.CarId

@Serializable
data class TLEventLastRace(
    var timeInMicroseconds: UInt = 0u,
    var carId: CarId = 0u,
    var obtainedSoloRewardsIndices: List<UByte> = listOf(),
    var maintenanceEnabled: Boolean = false,
)