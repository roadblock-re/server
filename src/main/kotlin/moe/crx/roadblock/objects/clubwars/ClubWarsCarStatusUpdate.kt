package moe.crx.roadblock.objects.clubwars

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.CarId
import moe.crx.roadblock.objects.account.CarRank
import moe.crx.roadblock.objects.account.CarUpgradeTier
import moe.crx.roadblock.objects.account.GarageValue

@Serializable
data class ClubWarsCarStatusUpdate(
    var id: CarId,
    var upgradeTier: CarUpgradeTier,
    var rank: CarRank,
    var garageValue: GarageValue,
)