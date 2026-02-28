package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.objects.Money
import moe.crx.roadblock.objects.inventory.CurrencyType
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ReceiveEvoTicketsOnCarMaxedRequest(
    var carId: CarId,
) : RequestPacket()

@Serializable
data class ReceiveEvoTicketsOnCarMaxedResponse(
    var currencyType: CurrencyType = CurrencyType.Credits,
    var quantity: Money = 0,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleReceiveEvoTicketsOnCarMaxed(
    session: GameConnection,
    request: ReceiveEvoTicketsOnCarMaxedRequest
) {
    session.sendResponse(ReceiveEvoTicketsOnCarMaxedResponse())
}