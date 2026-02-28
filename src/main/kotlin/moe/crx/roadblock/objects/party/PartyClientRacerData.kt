package moe.crx.roadblock.objects.party

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.objects.CarRank
import moe.crx.roadblock.objects.customization.CarVisualConfiguration
import moe.crx.roadblock.objects.inventory.CarClass

@Serializable
data class PartyClientRacerData(
    var carId: CarId,
    var carRank: CarRank,
    var carProgression: CarProgression,
    var carVisualConfiguration: CarVisualConfiguration,
    var carClass: CarClass,
    var isCarOverclocked: Boolean,
)