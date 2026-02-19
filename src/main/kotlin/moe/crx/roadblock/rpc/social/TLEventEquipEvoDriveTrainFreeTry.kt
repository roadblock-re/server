package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CarEvoTuningPartId
import moe.crx.roadblock.objects.account.CarId
import moe.crx.roadblock.objects.tle.TLEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class TLEventEquipEvoDriveTrainFreeTryRequest(
    var tlEventId: TLEventId,
    var carId: CarId,
    var evoTuningDriveTrainId: CarEvoTuningPartId?,
) : RequestPacket()

@Serializable
class TLEventEquipEvoDriveTrainFreeTryResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleTLEventEquipEvoDriveTrainFreeTry(
    session: GameConnection,
    request: TLEventEquipEvoDriveTrainFreeTryRequest
) {
    session.sendResponse(TLEventEquipEvoDriveTrainFreeTryResponse())
}