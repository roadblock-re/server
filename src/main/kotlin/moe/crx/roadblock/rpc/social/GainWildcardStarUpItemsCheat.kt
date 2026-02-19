package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.inventory.CarClass
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GainWildcardStarUpItemsCheatRequest(
    var carClass: CarClass,
    var addItem: UByte,
) : RequestPacket()

@Serializable
class GainWildcardStarUpItemsCheatResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGainWildcardStarUpItemsCheat(
    session: GameConnection,
    request: GainWildcardStarUpItemsCheatRequest
) {
    session.sendResponse(GainWildcardStarUpItemsCheatResponse())
}