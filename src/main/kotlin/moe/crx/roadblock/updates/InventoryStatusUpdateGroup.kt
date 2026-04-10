package moe.crx.roadblock.updates

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.UntilVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.*
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
            if (version newer "45.0.0") { // TODO find exact version
                add(InventoryStatusUpdateGroup2::class)
                add(InventoryStatusUpdateGroup3::class)
            }
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
            if (version older "45.0.0") { // TODO find exact version
                add(InventoryWalletRemoved::class)
            }
            add(InventoryWildcardBlueprintsChanged::class)
            if (version newer "45.0.0") { // TODO find exact version
                add(InventoryStatusUpdateGroup19::class)
                add(InventoryStatusUpdateGroup20::class)
            }
            if (version newer "24.0.0") {
                add(InventoryOverclockChipsChanged::class)
            }
            add(InventoryCarSpecificFreeUpgradesChanged::class)
            add(InventoryClassSpecificFreeUpgradesChanged::class)
            add(InventoryClassAndUnlockedTierSpecificFreeUpgradesChanged::class)
            add(InventoryCarVisualConfigurationChanged::class)
            if (version newer "45.0.0") { // TODO find exact version
                add(InventoryStatusUpdateGroup26::class)
            }
            add(InventoryCarCustomizationLocksChanged::class)
            add(InventoryCarDecalVisualOwnedChanged::class)
            add(InventoryCarCustomPartOwnedChanged::class)
            if (version newer "45.0.0") { // TODO find exact version
                add(InventoryStatusUpdateGroup30::class)
                add(InventoryStatusUpdateGroup31::class)
                add(InventoryStatusUpdateGroup32::class)
                add(InventoryStatusUpdateGroup33::class)
                add(InventoryStatusUpdateGroup34::class)
                add(InventoryStatusUpdateGroup35::class)
                add(InventoryStatusUpdateGroup36::class)
                add(InventoryStatusUpdateGroup37::class)
                add(InventoryStatusUpdateGroup38::class)
                add(InventoryStatusUpdateGroup39::class)
                add(InventoryStatusUpdateGroup40::class)
            }
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
data class InventoryCarIsClaimable(
    var carId: CarId
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryCarCanStarUp(
    var carId: CarId,
    var tier: CarUpgradeTier,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryStatusUpdateGroup2(
    var carId: CarId
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryStatusUpdateGroup3(
    var carId: CarId,
    var blueprints: UInt,
    var animationIds: List<String>,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryCarHasUnlockItemChanged(
    var carId: CarId,
    var isOwned: Boolean,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryCarOwnedStateChanged(
    var carId: CarId,
    var isOwned: Boolean,
    var oldBlueprintsForTier: Blueprints,
    var newBlueprintsForTier: Blueprints,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryCarOverclockedStateChanged(
    var carId: CarId,
    var overclockExpirationDate: Instant?,
    var actionType: UInt,
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
data class InventoryCarEvoTierBlueprintsChanged(
    var carId: CarId,
    var tier: CarUpgradeTier,
    var oldBlueprints: Blueprints,
    var newBlueprints: Blueprints,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryCarCanUpgradeEvoTier(
    var carId: CarId,
    var tier: CarUpgradeTier,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryCarEvoTierChanged(
    var carId: CarId,
    var oldTier: CarUpgradeTier?,
    var newTier: CarUpgradeTier?,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryCarRacesFinishedChanged(
    var carId: CarId,
    var mode: PlayModeType,
    var oldCount: RaceCount,
    var newCount: RaceCount,
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
data class InventoryCarUpgradeLevelChanged(
    var carId: CarId,
    var carStat: CarStatType,
    var oldLevel: CarUpgradeLevel,
    var newLevel: CarUpgradeLevel,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryCarUpgradeItemChanged(
    var carId: CarId,
    var carStat: CarStatType,
    var slotId: CarUpgradeItemSlotId,
    var applied: Boolean,
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
data class InventoryCarLastUsageChanged(
    var carId: CarId,
    var oldLastUsage: Instant,
    var newLastUsage: Instant,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryCarConsecutiveUsedDaysChanged(
    var carId: CarId,
    var oldConsecutiveDays: ConsecutiveDays,
    var newConsecutiveDays: ConsecutiveDays,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryWalletBalanceChanged(
    var currencyType: CurrencyType,
    var oldBalance: Money,
    var newBalance: Money,
    @UntilVersion("45.0.0") // TODO find exact version
    var seasonPassBonus: Money? = null,
    @UntilVersion("45.0.0") // TODO find exact version
    var bonusPassExtra: Money? = null,
    @UntilVersion("45.0.0") // TODO find exact version
    var eventId: CalendarEventId? = null,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryWalletAdded(
    var currencyType: CurrencyType,
    var balanceGain: Money,
    @UntilVersion("45.0.0") // TODO find exact version
    var eventId: CalendarEventId? = null,
    @FromVersion("45.0.0") // TODO find exact version
    var adLocation: String = "",
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

@Serializable
data class InventoryStatusUpdateGroup19(
    var carClass: CarClass,
    var oldUpgradeItems: UpgradeItems,
    var newUpgradeItems: UpgradeItems,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryStatusUpdateGroup20(
    var carClass: CarClass,
    var oldStarUpItems: UpgradeItems,
    var newStarUpItems: UpgradeItems,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryOverclockChipsChanged(
    var oldChips: OverclockChips,
    var newChips: OverclockChips,
    var eventId: CalendarEventId?,
    var carId: CarId?,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryCarSpecificFreeUpgradesChanged(
    var carStat: CarStatType,
    var carId: CarId,
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
data class InventoryClassAndUnlockedTierSpecificFreeUpgradesChanged(
    var carStat: CarStatType,
    var carClass: CarClass,
    var tier: CarUpgradeTier,
    var oldFreeUpgrades: FreeUpgrades,
    var newFreeUpgrades: FreeUpgrades,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryCarVisualConfigurationChanged(
    var carId: CarId,
    var visualConfiguration: CarVisualConfiguration,
    @FromVersion("45.0.0") // TODO find exact version
    var timeSpentInCustomizationMenu: ULong = 0u,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryStatusUpdateGroup26(
    var carId: CarId,
    var evoTuningPartsConfiguration: EvoTuningPartsConfiguration,
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
data class InventoryCarCustomPartOwnedChanged(
    var carId: CarId,
    var partId: CarCustomPartId,
    var oldOwnedState: Boolean,
    var newOwnedState: Boolean,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryStatusUpdateGroup30(
    var carId: CarId,
    var engineId: CarEvoTuningPartId,
    var oldOwnedState: Boolean,
    var newOwnedState: Boolean,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryStatusUpdateGroup31(
    var carId: CarId,
    var driveTrainId: CarEvoTuningPartId,
    var oldOwnedState: Boolean,
    var newOwnedState: Boolean,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryStatusUpdateGroup32(
    var carId: CarId,
    var nosId: CarEvoTuningPartId,
    var oldOwnedState: Boolean,
    var newOwnedState: Boolean,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryStatusUpdateGroup33(
    var carId: CarId,
    var intakeId: CarEvoTuningPartId,
    var oldOwnedState: Boolean,
    var newOwnedState: Boolean,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryStatusUpdateGroup34(
    var carId: CarId,
    var skitId: CarEvoTuningPartId,
    var oldOwnedState: Boolean,
    var newOwnedState: Boolean,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryStatusUpdateGroup35(
    var carId: CarId,
    var oldReceivedTicketsState: UByte,
    var newReceivedTicketsState: UByte,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryStatusUpdateGroup36(
    var carId: CarId,
    var optEngineId: CarEvoTuningPartId?,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryStatusUpdateGroup37(
    var carId: CarId,
    var optDriveTrainId: CarEvoTuningPartId?,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryStatusUpdateGroup38(
    var carId: CarId,
    var optIntakeId: CarEvoTuningPartId?,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryStatusUpdateGroup39(
    var carId: CarId,
    var optNosId: CarEvoTuningPartId?,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryStatusUpdateGroup40(
    var carId: CarId,
    var optSkitId: CarEvoTuningPartId?,
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
data class InventoryEmojiLockChanged(
    var emojiId: EmojiId,
    var isLocked: Boolean,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryFavoriteEmojisChanged(
    var favoriteEmojiIds: List<EmojiId>
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryMuteEmojisChanged(
    var muted: Boolean,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryAutoTrashStatusUpdate(
    var item: TrashableItem,
    var amount: UInt,
) : InventoryStatusUpdateGroup()

@Serializable
data class InventoryUpgradeItemsStatusUpdate(
    var item: UpgradeItem,
    var oldAmount: UpgradeItems,
    var newAmount: UpgradeItems,
) : InventoryStatusUpdateGroup()