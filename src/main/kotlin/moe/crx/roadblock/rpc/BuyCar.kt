package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class BuyCarRequest(
    var carId: CarId,
) : RequestPacket()

@Serializable
class BuyCarResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleBuyCar(
    session: GameConnection,
    request: BuyCarRequest
) {
    session.sendResponse(BuyCarResponse())
}