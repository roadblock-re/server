package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.AsphaltProductID
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class BonusPassBundleValidateProductPurchaseRequest(
    var bonusPassIds: List<CalendarEventId>,
    var productId: AsphaltProductID,
) : RequestPacket()

@Serializable
class BonusPassBundleValidateProductPurchaseResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleBonusPassBundleValidateProductPurchase(
    session: GameConnection,
    request: BonusPassBundleValidateProductPurchaseRequest
) {
    session.sendResponse(BonusPassBundleValidateProductPurchaseResponse())
}