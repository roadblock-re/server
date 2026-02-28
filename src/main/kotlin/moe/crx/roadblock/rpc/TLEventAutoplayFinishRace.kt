package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.tle.TLEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class TLEventAutoplayFinishRaceRequest(
    var tlEventId: TLEventId,
) : RequestPacket()

@Serializable
class TLEventAutoplayFinishRaceResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleTLEventAutoplayFinishRace(
    session: GameConnection,
    request: TLEventAutoplayFinishRaceRequest
) {
    session.sendResponse(TLEventAutoplayFinishRaceResponse())
}