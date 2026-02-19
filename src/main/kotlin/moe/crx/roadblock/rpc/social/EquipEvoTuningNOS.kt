package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CarEvoTuningPartId
import moe.crx.roadblock.objects.account.CarId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class EquipEvoTuningNOSRequest(
    var carId: CarId,
    var evoTuningEvoNOSId: CarEvoTuningPartId?,
) : RequestPacket()

@Serializable
class EquipEvoTuningNOSResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleEquipEvoTuningNOS(
    session: GameConnection,
    request: EquipEvoTuningNOSRequest
) {
    session.sendResponse(EquipEvoTuningNOSResponse())
}