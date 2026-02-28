package moe.crx.roadblock.updates

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.Blueprints
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.CarCustomPartId
import moe.crx.roadblock.objects.CarDecalVisualId
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.objects.CarUpgradeItemSlotId
import moe.crx.roadblock.objects.CarUpgradeLevel
import moe.crx.roadblock.objects.CarUpgradeTier
import moe.crx.roadblock.objects.ConsecutiveDays
import moe.crx.roadblock.objects.EmojiId
import moe.crx.roadblock.objects.FreeUpgrades
import moe.crx.roadblock.objects.MaintenanceSlots
import moe.crx.roadblock.objects.Money
import moe.crx.roadblock.objects.RaceCount
import moe.crx.roadblock.objects.UpgradeItems
import moe.crx.roadblock.objects.customization.CarCustomizationLockableSection
import moe.crx.roadblock.objects.customization.CarVisualConfiguration
import moe.crx.roadblock.objects.inventory.*
import moe.crx.roadblock.objects.multiplayer.PlayModeType

@Serializable
sealed class InventoryStatusUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<InventoryStatusUpdateGroup> {
        override fun variants(version: SerializationVersion) = buildList {
            add(InventoryCarIsClaimable::class)
            add(InventoryCarCanStarUp::class)
            add(InventoryCarHasUnlockItemChanged::class)
            add(InventoryCarOwnedStateChanged::class)
            if (version newer "24.0.0") {
                add(InventoryCarOverclockedStateChanged::class)
            }
            add(InventoryCarBlueprintsChanged::class)
            if (version older "24.0.0") {
                add(InventoryCarEvoTierBlueprintsChanged::class) // possible name
                add(InventoryCarCanUpgradeEvoTier::class) // possible name
                add(InventoryCarEvoTierChanged::class) // possible name
            }
            add(InventoryCarRacesFinishedChanged::class)
            add(InventoryCarUnlockedUpgradeTiersChanged::class)
            add(InventoryCarUpgradeLevelChanged::class)
            add(InventoryCarUpgradeItemChanged::class)
            add(InventoryCarMaintenanceBalanceChanged::class)
            add(InventoryCarMaintenanceStateChanged::class)
            add(InventoryCarLastUsageChanged::class)
            add(InventoryCarConsecutiveUsedDaysChanged::class)
            add(InventoryWalletBalanceChanged::class)
            add(InventoryWalletAdded::class)
            add(InventoryWalletRemoved::class)
            add(InventoryWildcardBlueprintsChanged::class)
            if (version newer "24.0.0") {
                add(InventoryOverclockChipsChanged::class)
            }
            add(InventoryCarSpecificFreeUpgradesChanged::class)
            add(InventoryClassSpecificFreeUpgradesChanged::class)
            add(InventoryClassAndUnlockedTierSpecificFreeUpgradesChanged::class)
            add(InventoryCarVisualConfigurationChanged::class)
            add(InventoryCarCustomizationLocksChanged::class)
            add(InventoryCarDecalVisualOwnedChanged::class)
            add(InventoryCarCustomPartOwnedChanged::class)
            add(InventoryMaintenanceBookingAdded::class)
            add(InventoryMaintenanceBookingRemoved::class)
            add(InventoryEmojiLockChanged::class)
            add(InventoryFavoriteEmojisChanged::class)
            add(InventoryMuteEmojisChanged::class)
            add(InventoryAutoTrashStatusUpdate::class)
            add(InventoryUpgradeItemsStatusUpdate::class)
        }
    }
}

@Serializable
data class InventoryAutoTrashStatusUpdate(
    var item: TrashableItem,
    var amount: UInt,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryCarBlueprintsChanged(
    var carId: CarId,
    var oldBlueprints: Blueprints,
    var newBlueprints: Blueprints,
    var oldBlueprintsForTier: Blueprints,
    var newBlueprintsForTier: Blueprints,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryCarCanStarUp(
    var carId: CarId,
    var tier: CarUpgradeTier,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryCarCanUpgradeEvoTier(
    var carId: CarId,
    var tier: CarUpgradeTier,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryCarConsecutiveUsedDaysChanged(
    var carId: CarId,
    var oldConsecutiveDays: ConsecutiveDays,
    var newConsecutiveDays: ConsecutiveDays,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryCarCustomPartOwnedChanged(
    var carId: CarId,
    var partId: CarCustomPartId,
    var oldOwnedState: Boolean,
    var newOwnedState: Boolean,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryCarCustomizationLocksChanged(
    var carId: CarId,
    var section: CarCustomizationLockableSection,
    var oldState: Boolean,
    var newState: Boolean,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryCarDecalVisualOwnedChanged(
    var carId: CarId,
    var visualId: CarDecalVisualId,
    var oldOwnedState: Boolean,
    var newOwnedState: Boolean,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryCarEvoTierBlueprintsChanged(
    var carId: CarId,
    var tier: CarUpgradeTier,
    var oldBlueprints: Blueprints,
    var newBlueprints: Blueprints,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryCarEvoTierChanged(
    var carId: CarId,
    var oldTier: CarUpgradeTier?,
    var newTier: CarUpgradeTier?,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryCarHasUnlockItemChanged(
    var carId: CarId,
    var isOwned: Boolean,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryCarIsClaimable(
    var carId: CarId
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryCarLastUsageChanged(
    var carId: CarId,
    var oldLastUsage: Instant,
    var newLastUsage: Instant,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryCarMaintenanceBalanceChanged(
    var carId: CarId,
    var oldSlots: MaintenanceSlots,
    var newSlots: MaintenanceSlots,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryCarMaintenanceStateChanged(
    var carId: CarId,
    var oldIsRefilling: Boolean,
    var newIsRefilling: Boolean,
    var oldEndRefillTime: Instant,
    var newEndRefillTime: Instant,
) : InventoryStatusUpdateGroup()

@Serializable
class InventoryCarOverclockedStateChanged : InventoryStatusUpdateGroup() // TODO

@Serializable
data class InventoryCarOwnedStateChanged(
    var carId: CarId,
    var isOwned: Boolean,
    var oldBlueprintsForTier: Blueprints,
    var newBlueprintsForTier: Blueprints,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryCarRacesFinishedChanged(
    var carId: CarId,
    var mode: PlayModeType,
    var oldCount: RaceCount,
    var newCount: RaceCount,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryCarSpecificFreeUpgradesChanged(
    var carStat: CarStatType,
    var carId: CarId,
    var oldFreeUpgrades: FreeUpgrades,
    var newFreeUpgrades: FreeUpgrades,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryCarUnlockedUpgradeTiersChanged(
    var carId: CarId,
    var oldTiers: CarUpgradeTier,
    var newTiers: CarUpgradeTier,
    var oldAvailableLevels: CarUpgradeLevel,
    var newAvailableLevels: CarUpgradeLevel,
    var oldBlueprintsForTier: Blueprints,
    var newBlueprintsForTier: Blueprints,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryCarUpgradeItemChanged(
    var carId: CarId,
    var carStat: CarStatType,
    var slotId: CarUpgradeItemSlotId,
    var applied: Boolean,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryCarUpgradeLevelChanged(
    var carId: CarId,
    var carStat: CarStatType,
    var oldLevel: CarUpgradeLevel,
    var newLevel: CarUpgradeLevel,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryCarVisualConfigurationChanged(
    var carId: CarId,
    var visualConfiguration: CarVisualConfiguration,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryClassAndUnlockedTierSpecificFreeUpgradesChanged(
    var carStat: CarStatType,
    var carClass: CarClass,
    var tier: CarUpgradeTier,
    var oldFreeUpgrades: FreeUpgrades,
    var newFreeUpgrades: FreeUpgrades,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryClassSpecificFreeUpgradesChanged(
    var carStat: CarStatType,
    var carClass: CarClass,
    var oldFreeUpgrades: FreeUpgrades,
    var newFreeUpgrades: FreeUpgrades,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryEmojiLockChanged(
    var emojiId: EmojiId,
    var isLocked: Boolean,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryFavoriteEmojisChanged(
    var favoriteEmojiIds: List<EmojiId>
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryMaintenanceBookingAdded(
    var booking: MaintenanceBooking
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryMaintenanceBookingRemoved(
    var booking: MaintenanceBooking,
    var reason: MaintenanceBookingRemoveReason,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryMuteEmojisChanged(
    var muted: Boolean,
) : InventoryStatusUpdateGroup()

@Serializable
class InventoryOverclockChipsChanged : InventoryStatusUpdateGroup() // TODO

@Serializable
data class InventoryUpgradeItemsStatusUpdate(
    var item: UpgradeItem,
    var oldAmount: UpgradeItems,
    var newAmount: UpgradeItems,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryWalletAdded(
    var currencyType: CurrencyType,
    var balance: Money,
    var eventId: CalendarEventId?,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryWalletBalanceChanged(
    var currencyType: CurrencyType,
    var oldBalance: Money,
    var newBalance: Money,
    var seasonPassBonus: Money?,
    var bonusPassExtra: Money?,
    var eventId: CalendarEventId?,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryWalletRemoved(
    var currencyType: CurrencyType,
    var eventId: CalendarEventId?,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryWildcardBlueprintsChanged(
    var carClass: CarClass,
    var tier: CarUpgradeTier,
    var oldBlueprints: Blueprints,
    var newBlueprints: Blueprints,
) : InventoryStatusUpdateGroup()