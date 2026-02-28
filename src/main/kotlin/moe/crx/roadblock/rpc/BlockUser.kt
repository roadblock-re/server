package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.social.Credentials
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class BlockUserRequest(
    var targetUserCredential: Credentials,
) : RequestPacket()

@Serializable
class BlockUserResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleBlockUser(
    session: GameConnection,
    request: BlockUserRequest
) {
    session.sendResponse(BlockUserResponse())
}