package moe.crx.roadblock.objects.uber

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.objects.UberExperience
import moe.crx.roadblock.objects.UberHazardLevel

@Serializable
data class UberSpecialEventData(
    var experience: UberExperience,
    var tierData: List<UberSpecialTierData>,
    var levelData: List<UberSpecialLevelData>,
    var currentHazardLevel: UberHazardLevel,
    var lastHazardCleanTime: Instant,
    var hasCurrencyBeenConverted: Boolean,
    var discoveredCars: List<CarId>,
)