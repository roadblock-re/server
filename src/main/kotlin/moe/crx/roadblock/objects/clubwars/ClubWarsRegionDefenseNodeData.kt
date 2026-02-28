package moe.crx.roadblock.objects.clubwars

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.CarId

@Serializable
data class ClubWarsRegionDefenseNodeData(
    var defenseAttempts: UShort,
    var assignedCar: CarId,
    var currentlyOccupying: Boolean,
)