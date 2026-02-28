package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.Blueprints
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ConvertWildcardBlueprintsRequest(
    var carId: CarId,
    var amount: Blueprints,
) : RequestPacket()

@Serializable
class ConvertWildcardBlueprintsResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleConvertWildcardBlueprints(
    session: GameConnection,
    request: ConvertWildcardBlueprintsRequest
) {
    session.sendResponse(ConvertWildcardBlueprintsResponse())
}