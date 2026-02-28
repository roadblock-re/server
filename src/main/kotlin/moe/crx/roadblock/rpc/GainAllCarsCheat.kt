package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GainAllCarsCheatRequest(
    var placeholder: Int,
) : RequestPacket()

@Serializable
class GainAllCarsCheatResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGainAllCarsCheat(
    session: GameConnection,
    request: GainAllCarsCheatRequest
) {
    session.sendResponse(GainAllCarsCheatResponse())
}