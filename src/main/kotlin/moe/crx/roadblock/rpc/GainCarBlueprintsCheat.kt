package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.Blueprints
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GainCarBlueprintsCheatRequest(
    var carId: CarId,
    var amount: Blueprints,
) : RequestPacket()

@Serializable
class GainCarBlueprintsCheatResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGainCarBlueprintsCheat(
    session: GameConnection,
    request: GainCarBlueprintsCheatRequest
) {
    session.sendResponse(GainCarBlueprintsCheatResponse())
}