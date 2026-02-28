package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.tle.TLEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class TLEventAutoplayStartRaceRequest(
    var tlEventId: TLEventId,
    var quantity: UByte,
) : RequestPacket()

@Serializable
class TLEventAutoplayStartRaceResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleTLEventAutoplayStartRace(
    session: GameConnection,
    request: TLEventAutoplayStartRaceRequest
) {
    session.sendResponse(TLEventAutoplayStartRaceResponse())
}