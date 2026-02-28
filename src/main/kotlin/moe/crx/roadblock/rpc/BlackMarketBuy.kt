package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.BlackMarketSlotId
import moe.crx.roadblock.objects.Money
import moe.crx.roadblock.objects.blackmarket.BlackMarketItem
import moe.crx.roadblock.objects.inventory.CurrencyType
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class BlackMarketBuyRequest(
    var slot: BlackMarketSlotId,
    var item: BlackMarketItem,
    var amount: UByte,
    var currency: CurrencyType,
    var cost: Money,
) : RequestPacket()

@Serializable
class BlackMarketBuyResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleBlackMarketBuy(
    session: GameConnection,
    request: BlackMarketBuyRequest
) {
    session.sendResponse(BlackMarketBuyResponse())
}