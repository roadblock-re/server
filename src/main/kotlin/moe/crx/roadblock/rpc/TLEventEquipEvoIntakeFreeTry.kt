package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CarEvoTuningPartId
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.objects.tle.TLEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class TLEventEquipEvoIntakeFreeTryRequest(
    var tlEventId: TLEventId,
    var carId: CarId,
    var evoTuningIntakeId: CarEvoTuningPartId?,
) : RequestPacket()

@Serializable
class TLEventEquipEvoIntakeFreeTryResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleTLEventEquipEvoIntakeFreeTry(
    session: GameConnection,
    request: TLEventEquipEvoIntakeFreeTryRequest
) {
    session.sendResponse(TLEventEquipEvoIntakeFreeTryResponse())
}