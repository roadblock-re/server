package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.BlackMarketSlotId
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.Money
import moe.crx.roadblock.objects.UberLevelId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class UberSpecialEventMarketBuyRequest(
    var eventId: CalendarEventId,
    var levelId: UberLevelId,
    var slotId: BlackMarketSlotId,
    var cost: Money,
    var amountToBuy: UInt,
) : RequestPacket()

@Serializable
class UberSpecialEventMarketBuyResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleUberSpecialEventMarketBuy(
    session: GameConnection,
    request: UberSpecialEventMarketBuyRequest
) {
    session.sendResponse(UberSpecialEventMarketBuyResponse())
}