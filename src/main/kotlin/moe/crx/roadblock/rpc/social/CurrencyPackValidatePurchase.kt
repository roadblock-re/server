package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.objects.account.AsphaltProductID
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class CurrencyPackValidatePurchaseRequest(
    var eventId: CalendarEventId,
    var productId: AsphaltProductID,
    @FromVersion("47.1.0")
    var shopType: UInt = 0u,
) : RequestPacket()

@Serializable
class CurrencyPackValidatePurchaseResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleCurrencyPackValidatePurchase(
    session: GameConnection,
    request: CurrencyPackValidatePurchaseRequest
) {
    session.sendResponse(CurrencyPackValidatePurchaseResponse())
}