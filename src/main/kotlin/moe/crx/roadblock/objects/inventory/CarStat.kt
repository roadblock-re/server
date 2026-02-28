package moe.crx.roadblock.objects.inventory

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.CarUpgradeItemSlotId
import moe.crx.roadblock.objects.CarUpgradeLevel

@Serializable
data class CarStat(
    var currentUpgradeLevel: CarUpgradeLevel = 0u,
    var upgradeItems: List<CarUpgradeItemSlotId> = listOf(),
)