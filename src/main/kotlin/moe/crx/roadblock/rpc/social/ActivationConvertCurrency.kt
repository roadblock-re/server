package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ActivationConvertCurrencyRequest(
    var eventId: CalendarEventId,
) : RequestPacket()

@Serializable
class ActivationConvertCurrencyResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleActivationConvertCurrency(
    session: GameConnection,
    request: ActivationConvertCurrencyRequest
) {
    session.sendResponse(ActivationConvertCurrencyResponse())
}