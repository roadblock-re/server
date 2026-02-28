package moe.crx.roadblock.objects.inventory

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.CarId

@Serializable
sealed class UpgradeItem {
    companion object : Variant<UpgradeItem> {
        override fun variants(version: SerializationVersion) = buildList {
            add(UncommonUpgradeItem::class)
            add(RareUpgradeItem::class)
            add(EpicUpgradeItem::class)
        }
    }
}

@Serializable
data class UncommonUpgradeItem(var carStat: CarStatType) : UpgradeItem()

@Serializable
data class RareUpgradeItem(var carStat: CarStatType, var carClass: CarClass) : UpgradeItem()

@Serializable
data class EpicUpgradeItem(var carId: CarId) : UpgradeItem()