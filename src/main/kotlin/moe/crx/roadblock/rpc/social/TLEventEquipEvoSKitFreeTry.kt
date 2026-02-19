package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CarEvoTuningPartId
import moe.crx.roadblock.objects.account.CarId
import moe.crx.roadblock.objects.tle.TLEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class TLEventEquipEvoSKitFreeTryRequest(
    var tlEventId: TLEventId,
    var carId: CarId,
    var evoTuningSKitId: CarEvoTuningPartId?,
) : RequestPacket()

@Serializable
class TLEventEquipEvoSKitFreeTryResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleTLEventEquipEvoSKitFreeTry(
    session: GameConnection,
    request: TLEventEquipEvoSKitFreeTryRequest
) {
    session.sendResponse(TLEventEquipEvoSKitFreeTryResponse())
}