package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.UntilVersion
import moe.crx.roadblock.objects.AsphaltProductID
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.RelayOfferTierId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ValidateIAPRelayOfferPurchaseRequest(
    var eventId: CalendarEventId,
    var tierId: RelayOfferTierId,
    var tierProductId: AsphaltProductID,
    @UntilVersion("47.1.0")
    var walletEventId: CalendarEventId? = null,
) : RequestPacket()

@Serializable
class ValidateIAPRelayOfferPurchaseResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleValidateIAPRelayOfferPurchase(
    session: GameConnection,
    request: ValidateIAPRelayOfferPurchaseRequest
) {
    session.sendResponse(ValidateIAPRelayOfferPurchaseResponse())
}