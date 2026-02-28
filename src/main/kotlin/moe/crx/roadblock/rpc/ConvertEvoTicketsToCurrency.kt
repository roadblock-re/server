package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ConvertEvoTicketsToCurrencyRequest(
    var carId: CarId,
) : RequestPacket()

@Serializable
class ConvertEvoTicketsToCurrencyResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleConvertEvoTicketsToCurrency(
    session: GameConnection,
    request: ConvertEvoTicketsToCurrencyRequest
) {
    session.sendResponse(ConvertEvoTicketsToCurrencyResponse())
}