package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.tle.TLEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class TLEventCompleteCheatRequest(
    var tlEventId: TLEventId,
) : RequestPacket()

@Serializable
class TLEventCompleteCheatResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleTLEventCompleteCheat(
    session: GameConnection,
    request: TLEventCompleteCheatRequest
) {
    session.sendResponse(TLEventCompleteCheatResponse())
}