package moe.crx.roadblock.updates.groups

import moe.crx.roadblock.objects.base.RVariant
import moe.crx.roadblock.game.serialization.SerializationVersion

class StatusUpdateGroup(ver: SerializationVersion) : RVariant(buildList {
    add(BlackMarketStatusUpdateGroup::class)
    add(BonusPassSystemStatusUpdateGroup::class)
    add(CareerStatusUpdateGroup::class)
    add(ChampionshipSystemStatusUpdateGroup::class)
    add(ClubRaceStatusUpdateGroup::class)
    add(ClubSystemStatusUpdateGroup::class)
    add(ClubWarsStatusUpdateGroup::class)
    add(DailyTasksStatusUpdateGroup::class)
    add(GachaSystemStatusUpdateGroup::class)
    if (ver newer "24.0.0") {
        add(GoldenChestSystemStatusUpdateGroup::class)
    }
    add(InboxStatusUpdateGroup::class)
    add(InventoryStatusUpdateGroup::class)
    add(LegendFundSystemStatusUpdateGroup::class)
    add(MiscellaneousStatusUpdateGroup::class)
    if (ver older "24.0.0") {
        add(MultiplayerChallengesStatusUpdateGroup::class)
    }
    add(MultiplayerSeriesStatusUpdateGroup::class)
    if (ver newer "24.0.0") {
        add(OverclockSystemStatusUpdateGroup::class)
    }
    add(PiggyBankSystemStatusUpdateGroup::class)
    add(PlayerStatsStatusUpdateGroup::class)
    add(PrivateLobbyStatusUpdateGroup::class)
    add(QuarantineStatusUpdateGroup::class)
    add(RelayOfferSystemStatusUpdateGroup::class)
    add(SeasonPassSystemStatusUpdateGroup::class)
    if (ver newer "24.0.0") {
        add(SeasonalCurrencySystemStatusUpdateGroup::class)
    }
    if (ver newer "24.1.0") {
        add(SocialSystemStatusUpdateGroup::class)
    }
    if (ver newer "24.0.0") {
        add(SponsorshipSystemStatusUpdateGroup::class)
    }
    add(TLEventsSystemStatusUpdateGroup::class)
    add(UberSystemStatusUpdateGroup::class)
    if (ver newer "24.0.0") {
        add(UpsellPopupSystemStatusUpdateGroup::class)
        add(VaultSystemStatusUpdateGroup::class)
    }
})