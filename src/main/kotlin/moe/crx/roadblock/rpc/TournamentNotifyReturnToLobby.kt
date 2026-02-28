package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.RoomId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class TournamentNotifyReturnToLobbyRequest(
    var roomId: RoomId,
) : RequestPacket()

@Serializable
class TournamentNotifyReturnToLobbyResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleTournamentNotifyReturnToLobby(
    session: GameConnection,
    request: TournamentNotifyReturnToLobbyRequest
) {
    session.sendResponse(TournamentNotifyReturnToLobbyResponse())
}