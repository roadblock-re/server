package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.social.StatusLine
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class UpdateStatusLineRequest(
    var statusLine: StatusLine,
    var debugForceRefresh: Boolean,
) : RequestPacket()

@Serializable
data class UpdateStatusLineResponse(
    var nextRefreshTime: UInt = 0u,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleUpdateStatusLine(
    session: GameConnection,
    request: UpdateStatusLineRequest
) {
    session.sendResponse(UpdateStatusLineResponse())
}