package moe.crx.roadblock.updates.groups

import moe.crx.roadblock.objects.base.RVariant
import moe.crx.roadblock.serialization.SerializationVersion
import moe.crx.roadblock.updates.inventory.*

class InventoryStatusUpdateGroup(ver: SerializationVersion) : RVariant(buildList {
    add(InventoryCarIsClaimable::class)
    add(InventoryCarCanStarUp::class)
    add(InventoryCarHasUnlockItemChanged::class)
    add(InventoryCarOwnedStateChanged::class)
    if (ver newer "24.0.0") {
        add(InventoryCarOverclockedStateChanged::class)
    }
    add(InventoryCarBlueprintsChanged::class)
    if (ver older "24.0.0") {
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
    if (ver newer "24.0.0") {
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
})