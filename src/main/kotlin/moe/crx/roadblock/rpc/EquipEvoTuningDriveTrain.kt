package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CarEvoTuningPartId
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class EquipEvoTuningDriveTrainRequest(
    var carId: CarId,
    var evoTuningEvoDriveTrainId: CarEvoTuningPartId?,
) : RequestPacket()

@Serializable
class EquipEvoTuningDriveTrainResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleEquipEvoTuningDriveTrain(
    session: GameConnection,
    request: EquipEvoTuningDriveTrainRequest
) {
    session.sendResponse(EquipEvoTuningDriveTrainResponse())
}