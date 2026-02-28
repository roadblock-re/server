package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.Blueprints
import moe.crx.roadblock.objects.inventory.CarClass
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GainWildcardUpgradeItemsCheatRequest(
    var carClass: CarClass,
    var amount: Blueprints,
) : RequestPacket()

@Serializable
class GainWildcardUpgradeItemsCheatResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGainWildcardUpgradeItemsCheat(
    session: GameConnection,
    request: GainWildcardUpgradeItemsCheatRequest
) {
    session.sendResponse(GainWildcardUpgradeItemsCheatResponse())
}