package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.AsphaltProductID
import moe.crx.roadblock.objects.LegendFundTierId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class LegendFundCancelProductPurchaseRequest(
    var productID: AsphaltProductID,
    var tierId: LegendFundTierId,
) : RequestPacket()

@Serializable
class LegendFundCancelProductPurchaseResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleLegendFundCancelProductPurchase(
    session: GameConnection,
    request: LegendFundCancelProductPurchaseRequest
) {
    session.sendResponse(LegendFundCancelProductPurchaseResponse())
}