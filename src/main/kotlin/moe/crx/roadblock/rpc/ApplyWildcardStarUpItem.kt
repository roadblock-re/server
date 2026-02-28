package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ApplyWildcardStarUpItemRequest(
    var carId: CarId,
) : RequestPacket()

@Serializable
class ApplyWildcardStarUpItemResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleApplyWildcardStarUpItem(
    session: GameConnection,
    request: ApplyWildcardStarUpItemRequest
) {
    session.sendResponse(ApplyWildcardStarUpItemResponse())
}