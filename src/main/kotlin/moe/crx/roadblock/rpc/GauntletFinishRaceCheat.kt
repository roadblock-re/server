package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GauntletFinishRaceCheatRequest(
    var eventId: CalendarEventId,
    var raceId: UByte,
    var win: Boolean,
) : RequestPacket()

@Serializable
class GauntletFinishRaceCheatResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGauntletFinishRaceCheat(
    session: GameConnection,
    request: GauntletFinishRaceCheatRequest
) {
    session.sendResponse(GauntletFinishRaceCheatResponse())
}