package moe.crx.roadblock.objects.models

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.DateTimeUnit.Companion.HOUR
import kotlinx.datetime.Instant
import kotlinx.datetime.plus
import kotlinx.serialization.Serializable
import moe.crx.roadblock.core.utils.midnight
import moe.crx.roadblock.objects.account.BlackMarketDailyRefreshes
import moe.crx.roadblock.objects.blackmarket.BlackMarketItem
import moe.crx.roadblock.objects.blackmarket.BlackMarketSlot
import moe.crx.roadblock.objects.blackmarket.BlackMarketSlotType
import moe.crx.roadblock.objects.inventory.CarClass
import moe.crx.roadblock.objects.inventory.CarStatType
import moe.crx.roadblock.objects.inventory.CurrencyType

@Serializable
data class BlackMarketState(
    var locked: Boolean = true,
    var slots: List<BlackMarketSlot> = listOf(
        BlackMarketSlot(
            item = BlackMarketItem.UpgradeItem.UncommonUpgradeItem(CarStatType.Handling),
            totalAmount = 5u,
            remainingAmount = 5u,
            currency = CurrencyType.Credits,
            basePrice = 25000,
            stepAmount = 13000,
            slotType = BlackMarketSlotType.UpgradeNow,
        ),
        BlackMarketSlot(
            item = BlackMarketItem.Blueprint(49u),
            totalAmount = 5u,
            remainingAmount = 5u,
            currency = CurrencyType.Tokens,
            basePrice = 65,
            stepAmount = 15,
            slotType = BlackMarketSlotType.NearFuture,
        ),
        BlackMarketSlot(
            item = BlackMarketItem.UpgradeItem.RareUpgradeItem(CarStatType.Handling, CarClass.C),
            totalAmount = 5u,
            remainingAmount = 5u,
            currency = CurrencyType.Credits,
            basePrice = 160000,
            stepAmount = 80000,
            slotType = BlackMarketSlotType.UpgradeNow,
        ),
        BlackMarketSlot(
            item = BlackMarketItem.Blueprint(103u),
            totalAmount = 5u,
            remainingAmount = 5u,
            currency = CurrencyType.Tokens,
            basePrice = 100,
            stepAmount = 10,
            slotType = BlackMarketSlotType.Random,
        ),
        BlackMarketSlot(
            item = BlackMarketItem.Blueprint(26u),
            totalAmount = 5u,
            remainingAmount = 5u,
            currency = CurrencyType.Credits,
            basePrice = 60000,
            stepAmount = 30000,
            slotType = BlackMarketSlotType.NearFuture,
        ),
        BlackMarketSlot(
            item = BlackMarketItem.UpgradeItem.RareUpgradeItem(CarStatType.Nitro, CarClass.C),
            totalAmount = 5u,
            remainingAmount = 5u,
            currency = CurrencyType.Tokens,
            basePrice = 140,
            stepAmount = 14,
            slotType = BlackMarketSlotType.Random,
        ),
        BlackMarketSlot(
            item = BlackMarketItem.Blueprint(102u),
            totalAmount = 1u,
            remainingAmount = 1u,
            currency = CurrencyType.Dust,
            basePrice = 500,
            stepAmount = 50,
            slotType = BlackMarketSlotType.Dust,
        ),
        BlackMarketSlot(
            item = BlackMarketItem.UpgradeItem.EpicUpgradeItem(102u),
            totalAmount = 1u,
            remainingAmount = 1u,
            currency = CurrencyType.Dust,
            basePrice = 6000,
            stepAmount = 600,
            slotType = BlackMarketSlotType.Dust,
        ),
    ),
    var consecutiveRefreshes: Map<BlackMarketItem, BlackMarketDailyRefreshes> = mapOf(),
    var cooldownRefreshes: Map<BlackMarketItem, BlackMarketDailyRefreshes> = mapOf(),
    var dailyRefreshes: BlackMarketDailyRefreshes = 0u,
    var nextDailyResetTime: Instant = now().midnight().plus(24, HOUR),
    var nextAutoRefreshTime: Instant = now().midnight().plus(24, HOUR),
)