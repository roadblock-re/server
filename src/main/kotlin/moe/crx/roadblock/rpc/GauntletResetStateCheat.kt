package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GauntletResetStateCheatRequest(
    var eventId: CalendarEventId,
) : RequestPacket()

@Serializable
class GauntletResetStateCheatResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGauntletResetStateCheat(
    session: GameConnection,
    request: GauntletResetStateCheatRequest
) {
    session.sendResponse(GauntletResetStateCheatResponse())
}