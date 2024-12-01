package moe.crx.roadblock.updates.groups

import moe.crx.roadblock.objects.base.RVariant
import moe.crx.roadblock.updates.inventory.*

class InventoryStatusUpdateGroup : RVariant(
    InventoryCarIsClaimable::class,
    InventoryCarCanStarUp::class,
    InventoryCarHasUnlockItemChanged::class,
    InventoryCarOwnedStateChanged::class,
    InventoryCarBlueprintsChanged::class,
    InventoryCarEvoTierBlueprintsChanged::class, // possible name
    InventoryCarCanUpgradeEvoTier::class, // possible name
    InventoryCarEvoTierChanged::class, // possible name
    InventoryCarRacesFinishedChanged::class,
    InventoryCarUnlockedUpgradeTiersChanged::class,
    InventoryCarUpgradeLevelChanged::class,
    InventoryCarUpgradeItemChanged::class,
    InventoryCarMaintenanceBalanceChanged::class,
    InventoryCarMaintenanceStateChanged::class,
    InventoryCarLastUsageChanged::class,
    InventoryCarConsecutiveUsedDaysChanged::class,
    InventoryWalletBalanceChanged::class,
    InventoryWalletAdded::class,
    InventoryWalletRemoved::class,
    InventoryWildcardBlueprintsChanged::class,
    InventoryCarSpecificFreeUpgradesChanged::class,
    InventoryClassSpecificFreeUpgradesChanged::class,
    InventoryClassAndUnlockedTierSpecificFreeUpgradesChanged::class,
    InventoryCarVisualConfigurationChanged::class,
    InventoryCarCustomizationLocksChanged::class,
    InventoryCarDecalVisualOwnedChanged::class,
    InventoryCarCustomPartOwnedChanged::class,
    InventoryMaintenanceBookingAdded::class,
    InventoryMaintenanceBookingRemoved::class,
    InventoryEmojiLockChanged::class,
    InventoryFavoriteEmojisChanged::class,
    InventoryMuteEmojisChanged::class,
    InventoryAutoTrashStatusUpdate::class,
    InventoryUpgradeItemsStatusUpdate::class,
)