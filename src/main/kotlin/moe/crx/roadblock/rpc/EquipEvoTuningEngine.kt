package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CarEvoTuningPartId
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class EquipEvoTuningEngineRequest(
    var carId: CarId,
    var evoTuningEvoEngineId: CarEvoTuningPartId?,
) : RequestPacket()

@Serializable
class EquipEvoTuningEngineResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleEquipEvoTuningEngine(
    session: GameConnection,
    request: EquipEvoTuningEngineRequest
) {
    session.sendResponse(EquipEvoTuningEngineResponse())
}