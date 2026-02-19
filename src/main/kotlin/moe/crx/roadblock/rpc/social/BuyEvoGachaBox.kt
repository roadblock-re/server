package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CarId
import moe.crx.roadblock.objects.account.PriceComponent
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class BuyEvoGachaBoxRequest(
    var carId: CarId,
    var evoBoxSlot: UShort,
    var price: PriceComponent,
) : RequestPacket()

@Serializable
class BuyEvoGachaBoxResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleBuyEvoGachaBox(
    session: GameConnection,
    request: BuyEvoGachaBoxRequest
) {
    session.sendResponse(BuyEvoGachaBoxResponse())
}