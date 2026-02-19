package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CarId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class MaintenanceValidateRefillRequest(
    var carId: CarId,
) : RequestPacket()

@Serializable
class MaintenanceValidateRefillResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleMaintenanceValidateRefill(
    session: GameConnection,
    request: MaintenanceValidateRefillRequest
) {
    session.sendResponse(MaintenanceValidateRefillResponse())
}