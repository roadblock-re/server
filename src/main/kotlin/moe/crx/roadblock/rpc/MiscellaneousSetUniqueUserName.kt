package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class MiscellaneousSetUniqueUserNameRequest(
    var username: String,
    var uniqueNamespace: String,
) : RequestPacket()

@Serializable
class MiscellaneousSetUniqueUserNameResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleMiscellaneousSetUniqueUserName(
    session: GameConnection,
    request: MiscellaneousSetUniqueUserNameRequest
) {
    session.sendResponse(MiscellaneousSetUniqueUserNameResponse())
}