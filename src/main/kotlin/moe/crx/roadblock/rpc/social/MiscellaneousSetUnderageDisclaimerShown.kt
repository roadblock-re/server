package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class MiscellaneousSetUnderageDisclaimerShownRequest(
    var shown: Boolean,
) : RequestPacket()

@Serializable
class MiscellaneousSetUnderageDisclaimerShownResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleMiscellaneousSetUnderageDisclaimerShown(
    session: GameConnection,
    request: MiscellaneousSetUnderageDisclaimerShownRequest
) {
    session.sendResponse(MiscellaneousSetUnderageDisclaimerShownResponse())
}