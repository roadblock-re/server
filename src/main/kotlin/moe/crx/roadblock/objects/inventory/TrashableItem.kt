package moe.crx.roadblock.objects.inventory

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.*

@Serializable
sealed class TrashableItem {
    companion object : Variant<TrashableItem> {
        override fun variants(version: SerializationVersion) = buildList {
            add(Blueprint::class)
            add(CarUpgradeItem::class)
            add(CarUnlockItem::class)
            add(CarCustomPart::class)
            add(CarDecalVisual::class)
            add(EmojiItem::class)
            if (version older "24.0.0") {
                add(VanityBadge::class)
            }
            add(WildcardBlueprint::class)
            add(OverclockChip::class)
        }
    }
}

@Serializable
data class Blueprint(var carId: CarId) : TrashableItem()

@Serializable
data class CarUpgradeItem(var item: UpgradeItem) : TrashableItem()

@Serializable
data class CarUnlockItem(var carId: CarId) : TrashableItem()

@Serializable
data class CarCustomPart(var carId: CarId, var partId: CarCustomPartId) : TrashableItem()

@Serializable
data class CarDecalVisual(var carId: CarId, var visualId: CarDecalVisualId) : TrashableItem()

@Serializable
data class EmojiItem(var emojiId: EmojiId) : TrashableItem()

@Serializable
data class VanityBadge(var badgeId: VanityBadgeId) : TrashableItem()

@Serializable
data class WildcardBlueprint(var carClass: CarClass, var tier: CarUpgradeTier) : TrashableItem()

@Serializable
class OverclockChip : TrashableItem()