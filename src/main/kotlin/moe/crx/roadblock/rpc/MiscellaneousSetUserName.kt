package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class MiscellaneousSetUserNameRequest(
    var username: String,
) : RequestPacket()

@Serializable
class MiscellaneousSetUserNameResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleMiscellaneousSetUserName(
    session: GameConnection,
    request: MiscellaneousSetUserNameRequest
) {
    session.sendResponse(MiscellaneousSetUserNameResponse())
}