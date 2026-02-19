package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.OnlineUserData
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class SearchGameFriendRequest(
    var friendAlias: String,
) : RequestPacket()

@Serializable
data class SearchGameFriendResponse(
    var userData: OnlineUserData,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleSearchGameFriend(
    session: GameConnection,
    request: SearchGameFriendRequest
) {
    TODO()
}