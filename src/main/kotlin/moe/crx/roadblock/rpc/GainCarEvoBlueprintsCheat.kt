package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.Blueprints
import moe.crx.roadblock.objects.CarEvoTier
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GainCarEvoBlueprintsCheatRequest(
    var carId: CarId,
    var carEvoTier: CarEvoTier,
    var amount: Blueprints,
) : RequestPacket()

@Serializable
class GainCarEvoBlueprintsCheatResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGainCarEvoBlueprintsCheat(
    session: GameConnection,
    request: GainCarEvoBlueprintsCheatRequest
) {
    session.sendResponse(GainCarEvoBlueprintsCheatResponse())
}