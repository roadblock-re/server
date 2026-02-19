package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.AsphaltProductID
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.objects.account.PiggyBankEventId
import moe.crx.roadblock.objects.account.PiggyBankTierId
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