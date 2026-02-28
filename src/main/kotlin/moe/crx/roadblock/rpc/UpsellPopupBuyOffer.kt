package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.UpsellPopupOfferIndex
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class UpsellPopupBuyOfferRequest(
    var eventId: CalendarEventId,
    var offerIndex: UpsellPopupOfferIndex,
) : RequestPacket()

@Serializable
class UpsellPopupBuyOfferResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleUpsellPopupBuyOffer(
    session: GameConnection,
    request: UpsellPopupBuyOfferRequest
) {
    session.sendResponse(UpsellPopupBuyOfferResponse())
}