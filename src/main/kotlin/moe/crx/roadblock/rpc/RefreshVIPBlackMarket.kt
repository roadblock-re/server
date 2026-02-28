package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.Money
import moe.crx.roadblock.objects.inventory.CurrencyType
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class RefreshVIPBlackMarketRequest(
    var currency: CurrencyType,
    var cost: Money,
) : RequestPacket()

@Serializable
class RefreshVIPBlackMarketResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleRefreshVIPBlackMarket(
    session: GameConnection,
    request: RefreshVIPBlackMarketRequest
) {
    session.sendResponse(RefreshVIPBlackMarketResponse())
}