package moe.crx.roadblock.objects.models

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.UntilVersion

@Serializable
data class State(
    var signature: UInt = GAME_SIGNATURE,
    var version: SerializationVersion,
    var blackMarket: BlackMarketState = BlackMarketState(),
    var career: CareerState = CareerState(),
    var gachaSystem: GachaSystemState = GachaSystemState(),
    var inventory: InventoryState = InventoryState(),
    var miscellaneous: MiscellaneousState = MiscellaneousState(),
    var multiplayerSeries: MultiplayerSeriesState = MultiplayerSeriesState(),
    var playerStats: PlayerStatsState = PlayerStatsState(),
    var clubSystem: ClubSystemState = ClubSystemState(),
    var tlEventsSystem: TLEventsSystemState = TLEventsSystemState(),
    var tracking: TrackingState = TrackingState(),
    var giftSystem: GiftSystemState = GiftSystemState(),
    var quarantine: QuarantineState = QuarantineState(),
    var dailyTasks: DailyTasksState = DailyTasksState(),
    var relayOfferSystem: RelayOfferSystemState = RelayOfferSystemState(),
    var uberSystem: UberSystemState = UberSystemState(),
    var championshipSystem: ChampionshipSystemState = ChampionshipSystemState(),
    var seasonPassSystem: SeasonPassSystemState = SeasonPassSystemState(),
    @UntilVersion("24.0.0")
    var multiplayerChallenges: MultiplayerChallengesState = MultiplayerChallengesState(),
    var inbox: InboxState = InboxState(),
    @UntilVersion("45.0.0")
    var clubWars: ClubWarsSystemState = ClubWarsSystemState(),
    var privateLobby: PrivateLobbyState = PrivateLobbyState(),
    var bonusPassSystem: BonusPassSystemState = BonusPassSystemState(),
    @FromVersion("3.7.0")
    var piggyBankSystem: PiggyBankSystemState = PiggyBankSystemState(),
    @FromVersion("3.8.0")
    var legendFundSystem: LegendFundSystemState = LegendFundSystemState(),
    @FromVersion("24.0.0")
    var vaultSystem: VaultSystemState = VaultSystemState(),
    @FromVersion("24.0.0") @UntilVersion("24.6.0")
    var seasonalCurrencySystem: SeasonalCurrencySystemState = SeasonalCurrencySystemState(),
    @FromVersion("24.0.0")
    var upsellPopupSystem: UpsellPopupSystemState = UpsellPopupSystemState(),
    @FromVersion("24.0.0")
    var overclockSystem: OverclockSystemState = OverclockSystemState(),
    @FromVersion("24.0.0")
    var sponsorshipSystem: SponsorshipSystemState = SponsorshipSystemState(),
    @FromVersion("24.0.0")
    var goldenChestSystem: GoldenChestSystemState = GoldenChestSystemState(),
    @FromVersion("24.1.0")
    var socialSystem: SocialSystemState = SocialSystemState(),
    @FromVersion("24.6.0")
    var gauntletSystem: GauntletSystemState = GauntletSystemState(),
    @FromVersion("24.6.0")
    var vipSystem: VipSystemState = VipSystemState(),
    @FromVersion("24.6.0")
    var activationSystem: ActivationSystemState = ActivationSystemState(), // Spotlight events
    @FromVersion("24.6.0")
    var tournamentSystem: TournamentSystemState = TournamentSystemState(),
    @FromVersion("45.0.0")
    var userCustomizableBundleSystem: UserCustomizableBundleSystemState = UserCustomizableBundleSystemState(),
) {
    companion object {
        const val GAME_SIGNATURE: UInt = 0x47DCEC79u
    }

    init {
        check(signature == GAME_SIGNATURE)
    }
}
