package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.objects.account.CarId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class OverclockApplyOverclockForCarCheatRequest(
    var carId: CarId,
    var eventId: CalendarEventId,
) : RequestPacket()

@Serializable
class OverclockApplyOverclockForCarCheatResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleOverclockApplyOverclockForCarCheat(
    session: GameConnection,
    request: OverclockApplyOverclockForCarCheatRequest
) {
    session.sendResponse(OverclockApplyOverclockForCarCheatResponse())
}