package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.objects.AsphaltProductID
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class PromotionValidatePurchaseRequest(
    var eventId: CalendarEventId,
    var productId: AsphaltProductID,
    @FromVersion("47.1.0")
    var shopType: UInt = 0u,
) : RequestPacket()

@Serializable
class PromotionValidatePurchaseResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handlePromotionValidatePurchase(
    session: GameConnection,
    request: PromotionValidatePurchaseRequest
) {
    session.sendResponse(PromotionValidatePurchaseResponse())
}