package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.objects.account.Money
import moe.crx.roadblock.objects.inventory.CurrencyType
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ActivationRefreshBlackMarketRequest(
    var eventId: CalendarEventId,
    var currency: CurrencyType,
    var cost: Money,
) : RequestPacket()

@Serializable
class ActivationRefreshBlackMarketResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleActivationRefreshBlackMarket(
    session: GameConnection,
    request: ActivationRefreshBlackMarketRequest
) {
    session.sendResponse(ActivationRefreshBlackMarketResponse())
}