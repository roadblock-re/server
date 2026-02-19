package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.AsphaltProductID
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.objects.account.IAPPriceData
import moe.crx.roadblock.objects.account.OfflineProductItem
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class PurchaseOfflineProductRequest(
    var productId: AsphaltProductID,
    var priceInfo: IAPPriceData,
    var items: List<OfflineProductItem>,
    var eventId: CalendarEventId?,
) : RequestPacket()

@Serializable
class PurchaseOfflineProductResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handlePurchaseOfflineProduct(
    session: GameConnection,
    request: PurchaseOfflineProductRequest
) {
    session.sendResponse(PurchaseOfflineProductResponse())
}