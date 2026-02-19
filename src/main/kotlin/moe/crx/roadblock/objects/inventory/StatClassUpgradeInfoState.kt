package moe.crx.roadblock.objects.inventory

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.FreeUpgrades
import moe.crx.roadblock.objects.account.UpgradeItems

@Serializable
data class StatClassUpgradeInfoState(
    var rareItems: UpgradeItems = 0u,
    var freeUpgrades: List<FreeUpgrades> = listOf(),
)