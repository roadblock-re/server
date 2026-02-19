package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.BlackMarketSlotId
import moe.crx.roadblock.objects.account.Money
import moe.crx.roadblock.objects.blackmarket.BlackMarketItem
import moe.crx.roadblock.objects.inventory.CurrencyType
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class VIPBlackMarketBuyRequest(
    var slot: BlackMarketSlotId,
    var item: BlackMarketItem,
    var amount: UByte,
    var currency: CurrencyType,
    var cost: Money,
) : RequestPacket()

@Serializable
class VIPBlackMarketBuyResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleVIPBlackMarketBuy(
    session: GameConnection,
    request: VIPBlackMarketBuyRequest
) {
    session.sendResponse(VIPBlackMarketBuyResponse())
}