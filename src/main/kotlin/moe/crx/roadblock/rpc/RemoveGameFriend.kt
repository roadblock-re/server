package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.social.Credentials
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class RemoveGameFriendRequest(
    var credentials: Credentials,
) : RequestPacket()

@Serializable
class RemoveGameFriendResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleRemoveGameFriend(
    session: GameConnection,
    request: RemoveGameFriendRequest
) {
    session.sendResponse(RemoveGameFriendResponse())
}