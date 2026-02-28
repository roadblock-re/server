package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.RaceToken
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class UberSpecialEventRegisterFinishRaceRequest(
    var raceToken: RaceToken,
) : RequestPacket()

@Serializable
class UberSpecialEventRegisterFinishRaceResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleUberSpecialEventRegisterFinishRace(
    session: GameConnection,
    request: UberSpecialEventRegisterFinishRaceRequest
) {
    session.sendResponse(UberSpecialEventRegisterFinishRaceResponse())
}