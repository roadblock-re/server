package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.AsphaltProductID
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.PiggyBankEventId
import moe.crx.roadblock.objects.PiggyBankTierId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class PiggyBankValidateProductPurchaseRequest(
    var eventId: CalendarEventId,
    var piggyBankEventId: PiggyBankEventId,
    var piggyBankTierId: PiggyBankTierId,
    var productId: AsphaltProductID,
) : RequestPacket()

@Serializable
class PiggyBankValidateProductPurchaseResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handlePiggyBankValidateProductPurchase(
    session: GameConnection,
    request: PiggyBankValidateProductPurchaseRequest
) {
    session.sendResponse(PiggyBankValidateProductPurchaseResponse())
}