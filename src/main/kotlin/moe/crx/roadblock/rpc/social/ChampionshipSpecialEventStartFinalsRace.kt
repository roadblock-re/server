package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.*
import moe.crx.roadblock.objects.inventory.CurrencyType
import moe.crx.roadblock.objects.settings.ControlSchemeType
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ChampionshipSpecialEventStartFinalsRaceRequest(
    var eventId: CalendarEventId,
    var roundId: ChampionshipRoundId,
    var carId: CarId,
    var controlSchemeType: ControlSchemeType,
    var currencyType: CurrencyType,
    var cost: Money,
) : RequestPacket()

@Serializable
data class ChampionshipSpecialEventStartFinalsRaceResponse(
    var raceToken: RaceToken = 0u,
    var requiredPlaybackDetailLevel: RequiredPlaybackDetailLevel = RequiredPlaybackDetailLevel.OnlyPlayer,
    var requiredPlaybackCondition: RequiredPlaybackCondition = RequiredPlaybackCondition.Never,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleChampionshipSpecialEventStartFinalsRace(
    session: GameConnection,
    request: ChampionshipSpecialEventStartFinalsRaceRequest
) {
    session.sendResponse(ChampionshipSpecialEventStartFinalsRaceResponse())
}