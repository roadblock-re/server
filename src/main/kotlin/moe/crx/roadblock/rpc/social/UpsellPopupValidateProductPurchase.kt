package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.objects.account.UpsellPopupOfferIndex
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class UpsellPopupValidateProductPurchaseRequest(
    var eventId: CalendarEventId,
    var offerIndex: UpsellPopupOfferIndex,
) : RequestPacket()

@Serializable
class UpsellPopupValidateProductPurchaseResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleUpsellPopupValidateProductPurchase(
    session: GameConnection,
    request: UpsellPopupValidateProductPurchaseRequest
) {
    session.sendResponse(UpsellPopupValidateProductPurchaseResponse())
}