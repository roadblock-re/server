package moe.crx.roadblock.objects.game

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.models.*

class State : RObject {

    var blackMarket: BlackMarketState = BlackMarketState()
    var career: CareerState = CareerState()
    var gachaSystem: GachaSystemSystemState = GachaSystemSystemState()
    var inventory: InventoryState = InventoryState()
    var miscellaneous: MiscellaneousState = MiscellaneousState()
    var multiplayerSeries: MultiplayerSeriesState = MultiplayerSeriesState()
    var playerStats: PlayerStatsState = PlayerStatsState()
    var clubSystem: ClubSystemState = ClubSystemState()
    var tlEventsSystem: TLEventsSystemState = TLEventsSystemState()
    var tracking: TrackingState = TrackingState()
    var giftSystem: GiftSystemState = GiftSystemState()
    var quarantine: QuarantineState = QuarantineState()
    var dailyTasks: DailyTasksState = DailyTasksState()
    var relayOfferSystem: RelayOfferSystemState = RelayOfferSystemState()
    var uberSystem: UberSystemState = UberSystemState()
    var championshipSystem: ChampionshipSystemState = ChampionshipSystemState()
    var seasonPassSystem: SeasonPassSystemState = SeasonPassSystemState()
    var multiplayerChallenges: MultiplayerChallengesState = MultiplayerChallengesState()
    var inbox: InboxState = InboxState()
    var clubWarsSystem: ClubWarsSystemState = ClubWarsSystemState()
    var privateLobby: PrivateLobbyState = PrivateLobbyState()
    var bonusPassSystem: BonusPassSystemState = BonusPassSystemState()
    var piggyBankSystem: PiggyBankSystemState = PiggyBankSystemState()
    var legendFundSystem: LegendFundSystemState = LegendFundSystemState() // 3.9+ only (also maybe 3.8)

    override fun read(sink: InputSink) {
        blackMarket = sink.readObject()
        career = sink.readObject()
        gachaSystem = sink.readObject()
        inventory = sink.readObject()
        miscellaneous = sink.readObject()
        multiplayerSeries = sink.readObject()
        playerStats = sink.readObject()
        clubSystem = sink.readObject()
        tlEventsSystem = sink.readObject()
        tracking = sink.readObject()
        giftSystem = sink.readObject()
        quarantine = sink.readObject()
        dailyTasks = sink.readObject()
        relayOfferSystem = sink.readObject()
        uberSystem = sink.readObject()
        championshipSystem = sink.readObject()
        seasonPassSystem = sink.readObject()
        multiplayerChallenges = sink.readObject()
        inbox = sink.readObject()
        clubWarsSystem = sink.readObject()
        privateLobby = sink.readObject()
        bonusPassSystem = sink.readObject()
        piggyBankSystem = sink.readObject()
        legendFundSystem = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(blackMarket)
        sink.writeObject(career)
        sink.writeObject(gachaSystem)
        sink.writeObject(inventory)
        sink.writeObject(miscellaneous)
        sink.writeObject(multiplayerSeries)
        sink.writeObject(playerStats)
        sink.writeObject(clubSystem)
        sink.writeObject(tlEventsSystem)
        sink.writeObject(tracking)
        sink.writeObject(giftSystem)
        sink.writeObject(quarantine)
        sink.writeObject(dailyTasks)
        sink.writeObject(relayOfferSystem)
        sink.writeObject(uberSystem)
        sink.writeObject(championshipSystem)
        sink.writeObject(seasonPassSystem)
        sink.writeObject(multiplayerChallenges)
        sink.writeObject(inbox)
        sink.writeObject(clubWarsSystem)
        sink.writeObject(privateLobby)
        sink.writeObject(bonusPassSystem)
        sink.writeObject(piggyBankSystem)
        sink.writeObject(legendFundSystem)
    }
}