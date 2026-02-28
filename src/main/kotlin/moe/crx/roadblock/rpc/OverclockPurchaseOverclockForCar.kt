package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.objects.OverclockChips
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class OverclockPurchaseOverclockForCarRequest(
    var carId: CarId,
    var duration: UInt,
    var cost: OverclockChips,
    var eventId: CalendarEventId,
) : RequestPacket()

@Serializable
class OverclockPurchaseOverclockForCarResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleOverclockPurchaseOverclockForCar(
    session: GameConnection,
    request: OverclockPurchaseOverclockForCarRequest
) {
    session.sendResponse(OverclockPurchaseOverclockForCarResponse())
}