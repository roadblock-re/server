package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.Credentials
import moe.crx.roadblock.objects.social.SocialRequest
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class RequestGameFriendRequest(
    var credentials: Credentials,
) : RequestPacket()

@Serializable
data class RequestGameFriendResponse(
    var request: SocialRequest,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleRequestGameFriend(
    session: GameConnection,
    request: RequestGameFriendRequest
) {
    TODO()
}