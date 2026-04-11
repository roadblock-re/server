package moe.crx.roadblock.objects.inventory

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.EnumList
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.game.serialization.UntilVersion
import moe.crx.roadblock.game.serialization.enumListOf
import moe.crx.roadblock.objects.*
import moe.crx.roadblock.objects.customization.CarCustomizationState

@Serializable
data class CarState(
    /**
     * Total amount of gained blueprints for this car.
     */
    var blueprints: Blueprints = 0u,
    /**
     * Should always be not nil, even when car is locked.
     */
    var unlockedTiers: CarUpgradeTier = 1u,
    /**
     * Should always be not nil, even when car is locked.
     */
    var unlockedLevels: CarUpgradeLevel = 4u,
    var carTuningState: CarTuningState = CarTuningState(),
    var epicUpgradeItems: UpgradeItems = 0u,
    var freeUpgradesForStat: EnumList<FreeUpgrades, CarStatType> = enumListOf { 0u },
    var maintenance: CarMaintenanceState,
    var usageStats: CarUsageStats = CarUsageStats(),
    @FromVersion("45.0.0")
    var ownedEvoTuningParts: EvoTuningParts = EvoTuningParts(),
    @FromVersion("47.1.0")
    var hasReceivedEvoTickets: Boolean = false,
    var customization: CarCustomizationState = CarCustomizationState(),
    /**
     * Amount of blueprints to unlock car or upgrade to the next tier.
     */
    var tierBlueprints: Blueprints = 0u,
    var ownedDecalVisuals: List<CarDecalVisualId> = listOf(),
    var isOwned: Boolean = false,
    var isCarKeyOwned: Boolean = false,
    var ownedCustomParts: List<CarCustomPartId> = listOf(),
    @UntilVersion("24.0.0")
    var currentEvoTier: CarEvoTier? = null,
    @UntilVersion("24.0.0")
    var evoTierBlueprints: Blueprints = 0u,
    @FromVersion("24.0.0") @UntilVersion("47.1.0")
    var overclockExpirationDate: Instant? = null,
    @FromVersion("24.6.0")
    var unlockedAssemblyBlueprints: Int = 0,
    @FromVersion("47.1.0")
    var overclockState: CarOverclockState = CarOverclockState(),
)