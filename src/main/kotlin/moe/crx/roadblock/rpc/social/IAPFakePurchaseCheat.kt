package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.AsphaltProductID
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class IAPFakePurchaseCheatRequest(
    var productId: AsphaltProductID,
) : RequestPacket()

@Serializable
class IAPFakePurchaseCheatResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleIAPFakePurchaseCheat(
    session: GameConnection,
    request: IAPFakePurchaseCheatRequest
) {
    session.sendResponse(IAPFakePurchaseCheatResponse())
}