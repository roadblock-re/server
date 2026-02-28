package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.AsphaltProductID
import moe.crx.roadblock.objects.LegendFundTierId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class LegendFundValidateProductPurchaseRequest(
    var productId: AsphaltProductID,
    var tierId: LegendFundTierId,
) : RequestPacket()

@Serializable
class LegendFundValidateProductPurchaseResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleLegendFundValidateProductPurchase(
    session: GameConnection,
    request: LegendFundValidateProductPurchaseRequest
) {
    session.sendResponse(LegendFundValidateProductPurchaseResponse())
}