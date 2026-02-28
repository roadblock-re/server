package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class MaintenanceStartRefillRequest(
    var carId: CarId,
) : RequestPacket()

@Serializable
class MaintenanceStartRefillResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleMaintenanceStartRefill(
    session: GameConnection,
    request: MaintenanceStartRefillRequest
) {
    session.sendResponse(MaintenanceStartRefillResponse())
}