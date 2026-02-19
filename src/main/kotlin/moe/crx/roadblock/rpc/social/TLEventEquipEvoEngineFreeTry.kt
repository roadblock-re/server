package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CarEvoTuningPartId
import moe.crx.roadblock.objects.account.CarId
import moe.crx.roadblock.objects.tle.TLEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class TLEventEquipEvoEngineFreeTryRequest(
    var tlEventId: TLEventId,
    var carId: CarId,
    var evoTuningEngineId: CarEvoTuningPartId?,
) : RequestPacket()

@Serializable
class TLEventEquipEvoEngineFreeTryResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleTLEventEquipEvoEngineFreeTry(
    session: GameConnection,
    request: TLEventEquipEvoEngineFreeTryRequest
) {
    session.sendResponse(TLEventEquipEvoEngineFreeTryResponse())
}