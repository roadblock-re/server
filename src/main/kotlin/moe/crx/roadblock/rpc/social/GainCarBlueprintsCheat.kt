package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.Blueprints
import moe.crx.roadblock.objects.account.CarId
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