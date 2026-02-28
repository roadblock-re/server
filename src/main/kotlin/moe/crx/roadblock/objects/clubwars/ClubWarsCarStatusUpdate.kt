package moe.crx.roadblock.objects.clubwars

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.objects.CarRank
import moe.crx.roadblock.objects.CarUpgradeTier
import moe.crx.roadblock.objects.GarageValue

@Serializable
data class ClubWarsCarStatusUpdate(
    var id: CarId,
    var upgradeTier: CarUpgradeTier,
    var rank: CarRank,
    var garageValue: GarageValue,
)