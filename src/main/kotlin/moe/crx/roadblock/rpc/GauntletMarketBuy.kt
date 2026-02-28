package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.objects.GauntletMarketProductId
import moe.crx.roadblock.objects.Money
import moe.crx.roadblock.objects.inventory.CurrencyType
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GauntletMarketBuyRequest(
    var productId: GauntletMarketProductId,
    var currency: CurrencyType,
    var cost: Money,
    var carId: CarId,
    var ignoreDivisionLock: Boolean,
) : RequestPacket()

@Serializable
class GauntletMarketBuyResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGauntletMarketBuy(
    session: GameConnection,
    request: GauntletMarketBuyRequest
) {
    session.sendResponse(GauntletMarketBuyResponse())
}