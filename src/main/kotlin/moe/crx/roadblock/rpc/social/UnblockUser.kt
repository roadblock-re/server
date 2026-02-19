package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.Credentials
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class UnblockUserRequest(
    var targetUserCredential: Credentials,
) : RequestPacket()

@Serializable
class UnblockUserResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleUnblockUser(
    session: GameConnection,
    request: UnblockUserRequest
) {
    session.sendResponse(UnblockUserResponse())
}