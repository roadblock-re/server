package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.Blob
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class RetrievePlaybackCheatRequest(
    var userFedId: String,
    var playbackName: String,
) : RequestPacket()

@Serializable
data class RetrievePlaybackCheatResponse(
    var playback: Blob = Blob(ByteArray(0))
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleRetrievePlaybackCheat(
    session: GameConnection,
    request: RetrievePlaybackCheatRequest
) {
    session.sendResponse(RetrievePlaybackCheatResponse())
}