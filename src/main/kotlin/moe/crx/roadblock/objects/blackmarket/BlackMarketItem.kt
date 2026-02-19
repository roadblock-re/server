package moe.crx.roadblock.objects.blackmarket

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.account.CarId
import moe.crx.roadblock.objects.account.CarUpgradeTier
import moe.crx.roadblock.objects.account.EmojiId
import moe.crx.roadblock.objects.account.VanityBadgeId
import moe.crx.roadblock.objects.inventory.CarClass
import moe.crx.roadblock.objects.inventory.CarStatType
import moe.crx.roadblock.objects.inventory.CurrencyType
import moe.crx.roadblock.objects.inventory.CustomizationPart

@Serializable
sealed class BlackMarketItem {
    companion object : Variant<BlackMarketItem> {
        override fun variants(version: SerializationVersion) = buildList {
            add(Blueprint::class)
            add(CarUnlockItem::class)
            add(Currency::class)
            add(CustomizationUnlock::class)
            add(EmojiItem::class)
            add(UpgradeItem::class)
            add(VanityBadge::class)
            add(WildcardBlueprint::class)
            add(OverclockChip::class)
            add(BlackMarketItemVariant9::class)
            add(BlackMarketItemVariant10::class)
            add(BlackMarketItemVariant11::class)
            add(BlackMarketItemVariant12::class)
            add(BlackMarketItemVariant13::class)
        }
    }

    @Serializable
    data class Blueprint(var carId: CarId) : BlackMarketItem()

    @Serializable
    data class CarUnlockItem(var carId: CarId) : BlackMarketItem()

    @Serializable
    data class Currency(var currency: CurrencyType) : BlackMarketItem()

    @Serializable
    data class CustomizationUnlock(var carId: CarId, var customization: CustomizationPart) : BlackMarketItem()

    @Serializable
    data class EmojiItem(var emojiId: EmojiId) : BlackMarketItem()

    @Serializable
    sealed class UpgradeItem : BlackMarketItem() {
        companion object : Variant<UpgradeItem> {
            override fun variants(version: SerializationVersion) = buildList {
                add(UncommonUpgradeItem::class)
                add(RareUpgradeItem::class)
                add(EpicUpgradeItem::class)
            }
        }

        @Serializable
        data class UncommonUpgradeItem(var carStat: CarStatType) : UpgradeItem()

        @Serializable
        data class RareUpgradeItem(var carStat: CarStatType, var carClass: CarClass) : UpgradeItem()

        @Serializable
        data class EpicUpgradeItem(var carId: CarId) : UpgradeItem()
    }

    @Serializable
    data class VanityBadge(var badgeId: VanityBadgeId) : BlackMarketItem()

    @Serializable
    data class WildcardBlueprint(var carClass: CarClass, var tier: CarUpgradeTier) : BlackMarketItem()

    @Serializable
    class OverclockChip : BlackMarketItem()

    @Serializable
    data class BlackMarketItemVariant9(var int: Int) : BlackMarketItem()

    @Serializable
    data class BlackMarketItemVariant10(var carClass: CarClass) : BlackMarketItem()

    @Serializable
    class BlackMarketItemVariant11 : BlackMarketItem()

    // TODO Inner property has 5 variants, all of them are 4 byte int
    @Serializable
    data class BlackMarketItemVariant12(var variant: UByte, var intValue: UInt) : BlackMarketItem()

    @Serializable
    data class BlackMarketItemVariant13(var carClass: CarClass) : BlackMarketItem()
}