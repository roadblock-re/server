package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CarEvoTuningPartId
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class EquipEvoTuningIntakeRequest(
    var carId: CarId,
    var evoTuningEvoIntakeId: CarEvoTuningPartId?,
) : RequestPacket()

@Serializable
class EquipEvoTuningIntakeResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleEquipEvoTuningIntake(
    session: GameConnection,
    request: EquipEvoTuningIntakeRequest
) {
    session.sendResponse(EquipEvoTuningIntakeResponse())
}