package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.SeasonPassTierId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class SeasonPassBuyTierRequest(
    var eventId: CalendarEventId,
    var tierId: SeasonPassTierId,
) : RequestPacket()

@Serializable
class SeasonPassBuyTierResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleSeasonPassBuyTier(
    session: GameConnection,
    request: SeasonPassBuyTierRequest
) {
    session.sendResponse(SeasonPassBuyTierResponse())
}