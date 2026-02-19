package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.RaceToken
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ChampionshipSpecialEventCancelRaceRequest(
    var raceToken: RaceToken,
    var raceTimeMicroseconds: UInt,
) : RequestPacket()

@Serializable
class ChampionshipSpecialEventCancelRaceResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleChampionshipSpecialEventCancelRace(
    session: GameConnection,
    request: ChampionshipSpecialEventCancelRaceRequest
) {
    session.sendResponse(ChampionshipSpecialEventCancelRaceResponse())
}