package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CarEvoTuningPartId
import moe.crx.roadblock.objects.account.CarId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class EquipEvoTuningSKitRequest(
    var carId: CarId,
    var evoTuningEvoSKitId: CarEvoTuningPartId?,
) : RequestPacket()

@Serializable
class EquipEvoTuningSKitResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleEquipEvoTuningSKit(
    session: GameConnection,
    request: EquipEvoTuningSKitRequest
) {
    session.sendResponse(EquipEvoTuningSKitResponse())
}