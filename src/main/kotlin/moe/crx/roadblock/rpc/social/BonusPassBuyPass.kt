package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.BonusPassId
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class BonusPassBuyPassRequest(
    var eventId: CalendarEventId,
    var bonusPassId: BonusPassId,
) : RequestPacket()

@Serializable
class BonusPassBuyPassResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleBonusPassBuyPass(
    session: GameConnection,
    request: BonusPassBuyPassRequest
) {
    session.sendResponse(BonusPassBuyPassResponse())
}