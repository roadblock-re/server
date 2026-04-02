package moe.crx.roadblock.objects.models

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.EnumList
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.game.serialization.UntilVersion
import moe.crx.roadblock.game.serialization.enumListOf
import moe.crx.roadblock.objects.*
import moe.crx.roadblock.objects.inventory.*

// TODO Do something about wallets. I don't know why GL made it so complicated.
// In 3.7 both wallets and iapWallets were List<WalletState> with currency and balance fields.
// From 3.9 (what about 3.8?) iapWallets became Map<CurrencyType, WalletState> and WalletState fields were changed.
// And from 45.0.0 they've changed WalletState fields back again! Why? What a disaster.

// 3.7
// WalletState: currency, balance
// wallets: List<WalletState>
// iapWallets: List<WalletState>

// 3.9
// WalletState: balance, currency, eventId
// wallets: List<WalletState>
// iapWallets: Map<urrencyType, WalletState>

// 24.6.0
// WalletState: balance, currency
// wallets: List<WalletState>
// iapWallets: Map<urrencyType, WalletState>

// 45.0.0
// WalletState: balance
// wallets: Map<CurrencyType, WalletState>
// iapWallets: Map<CurrencyType, WalletState>

@Serializable
data class InventoryState(
    var cars: Map<CarId, CarState> = mapOf(
        // Lancer
        0x25u to CarState(
            maintenance = CarMaintenanceState(6u),
            isOwned = true,
        ),
    ),
    @FromVersion("3.9.0")
    var wallets: List<WalletState> = listOf(
        WalletState(
            currency = CurrencyType.Credits,
            balance = 15000,
        ),
        WalletState(
            currency = CurrencyType.Tokens,
            balance = 50,
        ),
        WalletState(
            currency = CurrencyType.Dust,
            balance = 0,
        ),
        WalletState(
            currency = CurrencyType.UberTokens,
            balance = 0,
        ),
        WalletState(
            currency = CurrencyType.ClubWarsCoins,
            balance = 0,
        ),
        WalletState(
            currency = CurrencyType.ClubWarsTokens,
            balance = 0,
        ),
    ),
    @UntilVersion("3.9.0")
    var legacyWallets: Map<CurrencyType, WalletState> = wallets.associateBy { it.currency },
    var iapWallets: Map<CurrencyType, WalletState> = wallets.associate {
        it.currency to WalletState(
            currency = it.currency,
            balance = 0,
        )
    },
    @FromVersion("3.7.0")
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