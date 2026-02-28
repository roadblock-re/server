package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class MiscellaneousSetConsentNoticeShownRequest(
    var shown: Boolean,
) : RequestPacket()

@Serializable
class MiscellaneousSetConsentNoticeShownResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleMiscellaneousSetConsentNoticeShown(
    session: GameConnection,
    request: MiscellaneousSetConsentNoticeShownRequest
) {
    session.sendResponse(MiscellaneousSetConsentNoticeShownResponse())
}