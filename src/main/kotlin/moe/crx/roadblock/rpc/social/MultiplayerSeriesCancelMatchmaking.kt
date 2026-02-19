package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
class MultiplayerSeriesCancelMatchmakingRequest : RequestPacket()

@Serializable
class MultiplayerSeriesCancelMatchmakingResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleMultiplayerSeriesCancelMatchmaking(
    session: GameConnection,
    request: MultiplayerSeriesCancelMatchmakingRequest
) {
    session.sendResponse(MultiplayerSeriesCancelMatchmakingResponse())
}