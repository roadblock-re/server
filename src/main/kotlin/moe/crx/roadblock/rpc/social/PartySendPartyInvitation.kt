package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.Credentials
import moe.crx.roadblock.objects.account.RoomId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class PartySendPartyInvitationRequest(
    var targetFedId: Credentials,
    var roomId: RoomId,
) : RequestPacket()

@Serializable
class PartySendPartyInvitationResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handlePartySendPartyInvitation(
    session: GameConnection,
    request: PartySendPartyInvitationRequest
) {
    session.sendResponse(PartySendPartyInvitationResponse())
}