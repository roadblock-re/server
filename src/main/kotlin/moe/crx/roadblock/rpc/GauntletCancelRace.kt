package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.RaceToken
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GauntletCancelRaceRequest(
    var raceToken: RaceToken,
    var raceTimeMicroseconds: UInt,
) : RequestPacket()

@Serializable
class GauntletCancelRaceResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGauntletCancelRace(
    session: GameConnection,
    request: GauntletCancelRaceRequest
) {
    session.sendResponse(GauntletCancelRaceResponse())
}