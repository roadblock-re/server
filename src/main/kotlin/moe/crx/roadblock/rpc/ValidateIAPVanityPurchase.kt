package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.AsphaltProductID
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.objects.customization.CustomizationPart
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ValidateIAPVanityPurchaseRequest(
    var carId: CarId,
    var customizationProductId: AsphaltProductID,
    var customizationPart: CustomizationPart,
) : RequestPacket()

@Serializable
class ValidateIAPVanityPurchaseResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleValidateIAPVanityPurchase(
    session: GameConnection,
    request: ValidateIAPVanityPurchaseRequest
) {
    session.sendResponse(ValidateIAPVanityPurchaseResponse())
}