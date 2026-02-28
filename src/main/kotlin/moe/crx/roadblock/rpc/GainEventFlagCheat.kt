package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CareerEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GainEventFlagCheatRequest(
    var eventId: CareerEventId,
) : RequestPacket()

@Serializable
class GainEventFlagCheatResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGainEventFlagCheat(
    session: GameConnection,
    request: GainEventFlagCheatRequest
) {
    session.sendResponse(GainEventFlagCheatResponse())
}