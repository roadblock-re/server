package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.objects.customization.CustomizationPart
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class BuyCarVanityItemRequest(
    var carId: CarId,
    var customizationPart: CustomizationPart,
) : RequestPacket()

@Serializable
class BuyCarVanityItemResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleBuyCarVanityItem(
    session: GameConnection,
    request: BuyCarVanityItemRequest
) {
    session.sendResponse(BuyCarVanityItemResponse())
}