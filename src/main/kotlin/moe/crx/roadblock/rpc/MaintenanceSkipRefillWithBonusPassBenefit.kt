package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class MaintenanceSkipRefillWithBonusPassBenefitRequest(
    var carId: CarId,
) : RequestPacket()

@Serializable
class MaintenanceSkipRefillWithBonusPassBenefitResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleMaintenanceSkipRefillWithBonusPassBenefit(
    session: GameConnection,
    request: MaintenanceSkipRefillWithBonusPassBenefitRequest
) {
    session.sendResponse(MaintenanceSkipRefillWithBonusPassBenefitResponse())
}