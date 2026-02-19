package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class XboxLiveOnlyEnableRequest(
    var isEnable: Boolean,
    var debugSuffix: String,
) : RequestPacket()

@Serializable
class XboxLiveOnlyEnableResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleXboxLiveOnlyEnable(
    session: GameConnection,
    request: XboxLiveOnlyEnableRequest
) {
    session.sendResponse(XboxLiveOnlyEnableResponse())
}