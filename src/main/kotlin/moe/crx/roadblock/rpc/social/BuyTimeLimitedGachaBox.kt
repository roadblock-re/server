package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class BuyTimeLimitedGachaBoxRequest(
    var calendarEventId: CalendarEventId,
    var count: UInt,
    var compactRewards: Boolean,
    var doCriticalRoll: Boolean,
    var walletEventId: CalendarEventId?,
) : RequestPacket()

@Serializable
class BuyTimeLimitedGachaBoxResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleBuyTimeLimitedGachaBox(
    session: GameConnection,
    request: BuyTimeLimitedGachaBoxRequest
) {
    session.sendResponse(BuyTimeLimitedGachaBoxResponse())
}