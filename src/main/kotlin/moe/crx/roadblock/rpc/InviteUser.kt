package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.ClubId
import moe.crx.roadblock.objects.social.Credentials
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class InviteUserRequest(
    var userCredential: Credentials,
    var clubId: ClubId,
) : RequestPacket()

@Serializable
class InviteUserResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleInviteUser(
    session: GameConnection,
    request: InviteUserRequest
) {
    session.sendResponse(InviteUserResponse())
}