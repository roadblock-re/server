package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.AsphaltProductID
import moe.crx.roadblock.objects.account.BonusPassId
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class BonusPassValidateProductPurchaseRequest(
    var eventId: CalendarEventId,
    var bonusPassId: BonusPassId,
    var productId: AsphaltProductID,
) : RequestPacket()

@Serializable
class BonusPassValidateProductPurchaseResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleBonusPassValidateProductPurchase(
    session: GameConnection,
    request: BonusPassValidateProductPurchaseRequest
) {
    session.sendResponse(BonusPassValidateProductPurchaseResponse())
}