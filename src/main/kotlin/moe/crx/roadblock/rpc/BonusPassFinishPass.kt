package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.BonusPassId
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class BonusPassFinishPassRequest(
    var eventId: CalendarEventId,
    var bonusPassId: BonusPassId,
) : RequestPacket()

@Serializable
class BonusPassFinishPassResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleBonusPassFinishPass(
    session: GameConnection,
    request: BonusPassFinishPassRequest
) {
    session.sendResponse(BonusPassFinishPassResponse())
}