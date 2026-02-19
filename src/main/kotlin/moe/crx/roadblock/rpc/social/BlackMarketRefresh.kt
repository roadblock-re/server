package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.objects.account.Money
import moe.crx.roadblock.objects.inventory.CurrencyType
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class BlackMarketRefreshRequest(
    @FromVersion("47.1.0")
    var currency: CurrencyType = CurrencyType.Tokens,
    var cost: Money,
    var shuffleSlots: Boolean,
) : RequestPacket()

@Serializable
class BlackMarketRefreshResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleBlackMarketRefresh(
    session: GameConnection,
    request: BlackMarketRefreshRequest
) {
    session.sendResponse(BlackMarketRefreshResponse())
}