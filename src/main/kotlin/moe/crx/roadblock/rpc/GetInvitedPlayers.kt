package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.social.Credentials
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
class GetInvitedPlayersRequest : RequestPacket()

@Serializable
data class GetInvitedPlayersResponse(
    var invitedPlayers: List<Credentials> = listOf(),
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGetInvitedPlayers(
    session: GameConnection,
    request: GetInvitedPlayersRequest
) {
    session.sendResponse(GetInvitedPlayersResponse())
}