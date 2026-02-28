package moe.crx.roadblock.objects.models

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.EnumList
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.game.serialization.enumListOf
import moe.crx.roadblock.objects.Blueprints
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.objects.CarUpgradeTier
import moe.crx.roadblock.objects.OverclockChips
import moe.crx.roadblock.objects.UpgradeItems
import moe.crx.roadblock.objects.inventory.*

@Serializable
data class InventoryState(
    var cars: Map<CarId, CarState> = mapOf(
        // Lancer
        0x25u to CarState(
            maintenance = CarMaintenanceState(6u),
            isOwned = true,
        ),
    ),
    var wallets: List<WalletState> = listOf(
        WalletState(
            currency = CurrencyType.Credits,
            balance = 15000,
        ),
        WalletState(
            currency = CurrencyType.Tokens,
            balance = 50,
        ),
    ),
    var iapWallets: Map<CurrencyType, WalletState> = mapOf(),
    var wildcardBlueprints: EnumList<Map<CarUpgradeTier, Blueprints>, CarClass> = enumListOf { mapOf() },
    @FromVersion("24.6.0")
    var wildcardUpgradeItems: EnumList<UpgradeItems, CarClass> = enumListOf { 0u },
    @FromVersion("47.1.0")
    var wildcardStarUpItems: EnumList<UpgradeItems, CarClass> = enumListOf { 0u },
    var upgradeInfoState: EnumList<StatUpgradeInfoState, CarStatType> = enumListOf { StatUpgradeInfoState() },
    var lastActionTime: Instant = now(),
    var booking: List<MaintenanceBooking>? = null,
    var emojis: EmojisState = EmojisState(),
    @FromVersion("24.0.0")
    var overclockChips: OverclockChips = 0u,
)