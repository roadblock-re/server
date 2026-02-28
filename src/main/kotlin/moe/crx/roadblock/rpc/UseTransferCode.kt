package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class UseTransferCodeRequest(
    var code: String,
) : RequestPacket()

@Serializable
class UseTransferCodeResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleUseTransferCode(
    session: GameConnection,
    request: UseTransferCodeRequest
) {
    session.sendResponse(UseTransferCodeResponse())
}