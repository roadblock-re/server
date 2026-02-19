package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.Credentials
import moe.crx.roadblock.objects.account.RoomId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class PartyKickUserRequest(
    var roomId: RoomId,
    var userToKickAnubisCredentials: Credentials,
    var userToKickFedId: Credentials,
) : RequestPacket()

@Serializable
class PartyKickUserResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handlePartyKickUser(
    session: GameConnection,
    request: PartyKickUserRequest
) {
    session.sendResponse(PartyKickUserResponse())
}