package moe.crx.roadblock.updates.groups

import moe.crx.roadblock.objects.base.RVariant

class StatusUpdateGroup : RVariant(
    BlackMarketStatusUpdateGroup::class,
    BonusPassSystemStatusUpdateGroup::class,
    CareerStatusUpdateGroup::class, //0x02!!
    ChampionshipSystemStatusUpdateGroup::class,
    ClubRaceStatusUpdateGroup::class,
    ClubSystemStatusUpdateGroup::class, //0x05!!
    ClubWarsStatusUpdateGroup::class,
    DailyTasksStatusUpdateGroup::class,
    GachaSystemStatusUpdateGroup::class,
    //GoldenChestSystemStatusUpdateGroup::class, //ALU
    InboxStatusUpdateGroup::class,
    InventoryStatusUpdateGroup::class, //0x0A!!
    LegendFundSystemStatusUpdateGroup::class,
    MiscellaneousStatusUpdateGroup::class,
    MultiplayerChallengesStatusUpdateGroup::class, // removed in ALU
    MultiplayerSeriesStatusUpdateGroup::class, //0x0E
    //OverclockSystemStatusUpdateGroup::class, //ALU
    PiggyBankSystemStatusUpdateGroup::class,
    PlayerStatsStatusUpdateGroup::class, //0x10!!
    PrivateLobbyStatusUpdateGroup::class,
    QuarantineStatusUpdateGroup::class,
    RelayOfferSystemStatusUpdateGroup::class,
    SeasonPassSystemStatusUpdateGroup::class,
    //SeasonalCurrencySystemStatusUpdateGroup::class, //ALU
    //SocialSystemStatusUpdateGroup::class, //ALU
    //SponsorshipSystemStatusUpdateGroup::class, //ALU
    TLEventsSystemStatusUpdateGroup::class,
    UberSystemStatusUpdateGroup::class,
    //UpsellPopupSystemStatusUpdateGroup::class, //ALU
    //VaultSystemStatusUpdateGroup::class, //ALU
)