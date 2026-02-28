package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.RaceToken
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class UberSpecialEventCancelRaceRequest(
    var raceToken: RaceToken,
    var raceTimeMicroseconds: Int,
) : RequestPacket()

@Serializable
class UberSpecialEventCancelRaceResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleUberSpecialEventCancelRace(
    session: GameConnection,
    request: UberSpecialEventCancelRaceRequest
) {
    session.sendResponse(UberSpecialEventCancelRaceResponse())
}