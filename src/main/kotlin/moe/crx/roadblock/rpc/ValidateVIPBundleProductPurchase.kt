package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ValidateVIPBundleProductPurchaseRequest(
    var bundleLevel: UByte,
) : RequestPacket()

@Serializable
class ValidateVIPBundleProductPurchaseResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleValidateVIPBundleProductPurchase(
    session: GameConnection,
    request: ValidateVIPBundleProductPurchaseRequest
) {
    session.sendResponse(ValidateVIPBundleProductPurchaseResponse())
}