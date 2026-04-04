package moe.crx.roadblock.updates

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant

@Serializable
sealed class StatusUpdateGroup {

    @Transient
    var children: List<StatusUpdateGroup> = listOf()

    fun children(vararg values: StatusUpdateGroup): StatusUpdateGroup {
        children = values.toList()
        return this
    }

    companion object : Variant<StatusUpdateGroup> {
        override fun variants(version: SerializationVersion) = buildList {
            // This is sorted by alphabet lmao
            if (version newer "45.0.0") { // TODO find exact version
                add(ActivationSystemStatusUpdateGroup::class)
            }
            add(BlackMarketStatusUpdateGroup::class)
            add(BonusPassSystemStatusUpdateGroup::class)
            add(CareerStatusUpdateGroup::class)
            add(ChampionshipSystemStatusUpdateGroup::class) // TODO
            if (version older "45.0.0") { // TODO find exact version
                add(ClubRaceStatusUpdateGroup::class)
            }
            add(ClubSystemStatusUpdateGroup::class) // TODO
            if (version older "45.0.0") {
                add(ClubWarsStatusUpdateGroup::class)
            }
            add(DailyTasksStatusUpdateGroup::class) // TODO
            add(GachaSystemStatusUpdateGroup::class) // TODO
            if (version newer "24.5.0") {
                add(GauntletSystemStatusUpdateGroup::class) // TODO
            }
            if (version newer "24.0.0") {
                add(GoldenChestSystemStatusUpdateGroup::class) // TODO
            }
            add(InboxStatusUpdateGroup::class) // TODO
            add(InventoryStatusUpdateGroup::class) //  TODO
            add(LegendFundSystemStatusUpdateGroup::class) // TODO
            add(MiscellaneousStatusUpdateGroup::class) // TODO
            if (version older "24.0.0") {
                add(MultiplayerChallengesStatusUpdateGroup::class)
            }
            add(MultiplayerSeriesStatusUpdateGroup::class) // TODO
            if (version newer "24.0.0") {
                add(OverclockSystemStatusUpdateGroup::class) // TODO
            }
            add(PiggyBankSystemStatusUpdateGroup::class) // TODO
            add(PlayerStatsStatusUpdateGroup::class) // TODO
            add(PrivateLobbyStatusUpdateGroup::class) // TODO
            add(QuarantineStatusUpdateGroup::class) // TODO
            add(RelayOfferSystemStatusUpdateGroup::class) // TODO
            add(SeasonPassSystemStatusUpdateGroup::class) // TODO
            if (version newer "24.0.0") {
                add(SeasonalCurrencySystemStatusUpdateGroup::class)
            }
            if (version newer "24.1.0") {
                add(SocialSystemStatusUpdateGroup::class) // TODO
            }
            if (version newer "24.0.0") {
                add(SponsorshipSystemStatusUpdateGroup::class) // TODO
            }
            add(TLEventsSystemStatusUpdateGroup::class) // TODO
            if (version newer "45.0.0") { // TODO find exact version
                // TODO Here is one group with one update with one variable "placement": ushort
            }
            add(UberSystemStatusUpdateGroup::class) // TODO
            if (version newer "24.0.0") {
                add(UpsellPopupSystemStatusUpdateGroup::class) // TODO
            }
            if (version newer "45.0.0") { // TODO find exact version
                //TODO No idea. 3 updates. eventIds; eventId; eventId, eventExpirationDate; eventId, productId.
            }
            if (version newer "45.0.0") { // TODO find exact version
                //TODO VipSystemStatusUpdateGroup Why it doesn't match sorting by alphabet?
            }
            if (version newer "24.0.0") {
                add(VaultSystemStatusUpdateGroup::class) // TODO
            }
        }
    }
}