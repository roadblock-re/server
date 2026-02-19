package moe.crx.roadblock.objects.multiplayer

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.EnumList
import moe.crx.roadblock.objects.account.CarUpgradeLevel
import moe.crx.roadblock.objects.account.CarUpgradeTier
import moe.crx.roadblock.objects.account.UpgradeItems
import moe.crx.roadblock.objects.inventory.CarStatType

@Serializable
data class CarPreset(
    var type: CarPresetType,
    var tierLevel: CarUpgradeTier,
    var upgradeLevelInfo: EnumList<CarUpgradeLevel, CarStatType>,
    var importPartsInfo: EnumList<UpgradeItems, CarItemRarity>,
)