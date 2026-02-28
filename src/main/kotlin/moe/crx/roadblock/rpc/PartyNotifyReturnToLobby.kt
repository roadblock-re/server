package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.RoomId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class PartyNotifyReturnToLobbyRequest(
    var roomId: RoomId,
) : RequestPacket()

@Serializable
class PartyNotifyReturnToLobbyResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handlePartyNotifyReturnToLobby(
    session: GameConnection,
    request: PartyNotifyReturnToLobbyRequest
) {
    session.sendResponse(PartyNotifyReturnToLobbyResponse())
}