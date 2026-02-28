package moe.crx.roadblock.updates

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant

@Serializable
sealed class StatusUpdateGroup {
    companion object : Variant<StatusUpdateGroup> {
        override fun variants(version: SerializationVersion) = buildList {
            add(BlackMarketStatusUpdateGroup::class)
            add(BonusPassSystemStatusUpdateGroup::class)
            add(CareerStatusUpdateGroup::class)
            add(ChampionshipSystemStatusUpdateGroup::class)
            add(ClubRaceStatusUpdateGroup::class)
            add(ClubSystemStatusUpdateGroup::class)
            add(ClubWarsStatusUpdateGroup::class)
            add(DailyTasksStatusUpdateGroup::class)
            add(GachaSystemStatusUpdateGroup::class)
            if (version newer "24.0.0") {
                add(GoldenChestSystemStatusUpdateGroup::class)
            }
            add(InboxStatusUpdateGroup::class)
            add(InventoryStatusUpdateGroup::class)
            add(LegendFundSystemStatusUpdateGroup::class)
            add(MiscellaneousStatusUpdateGroup::class)
            if (version older "24.0.0") {
                add(MultiplayerChallengesStatusUpdateGroup::class)
            }
            add(MultiplayerSeriesStatusUpdateGroup::class)
            if (version newer "24.0.0") {
                add(OverclockSystemStatusUpdateGroup::class)
            }
            add(PiggyBankSystemStatusUpdateGroup::class)
            add(PlayerStatsStatusUpdateGroup::class)
            add(PrivateLobbyStatusUpdateGroup::class)
            add(QuarantineStatusUpdateGroup::class)
            add(RelayOfferSystemStatusUpdateGroup::class)
            add(SeasonPassSystemStatusUpdateGroup::class)
            if (version newer "24.0.0") {
                add(SeasonalCurrencySystemStatusUpdateGroup::class)
            }
            if (version newer "24.1.0") {
                add(SocialSystemStatusUpdateGroup::class)
            }
            if (version newer "24.0.0") {
                add(SponsorshipSystemStatusUpdateGroup::class)
            }
            add(TLEventsSystemStatusUpdateGroup::class)
            add(UberSystemStatusUpdateGroup::class)
            if (version newer "24.0.0") {
                add(UpsellPopupSystemStatusUpdateGroup::class)
                add(VaultSystemStatusUpdateGroup::class)
            }
        }
    }
}