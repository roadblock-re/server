package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CarId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class MaintenanceSkipRefillWithTokensRequest(
    var carId: CarId,
) : RequestPacket()

@Serializable
class MaintenanceSkipRefillWithTokensResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleMaintenanceSkipRefillWithTokens(
    session: GameConnection,
    request: MaintenanceSkipRefillWithTokensRequest
) {
    session.sendResponse(MaintenanceSkipRefillWithTokensResponse())
}