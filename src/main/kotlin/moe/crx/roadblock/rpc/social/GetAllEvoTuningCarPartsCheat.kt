package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CarId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GetAllEvoTuningCarPartsCheatRequest(
    var carId: CarId,
) : RequestPacket()

@Serializable
class GetAllEvoTuningCarPartsCheatResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGetAllEvoTuningCarPartsCheat(
    session: GameConnection,
    request: GetAllEvoTuningCarPartsCheatRequest
) {
    session.sendResponse(GetAllEvoTuningCarPartsCheatResponse())
}