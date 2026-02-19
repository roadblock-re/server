package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CarId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GainAllCarItemsCheatRequest(
    var carId: CarId,
    var gainBlueprints: Boolean,
    var gainUpgradeItems: Boolean,
) : RequestPacket()

@Serializable
class GainAllCarItemsCheatResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGainAllCarItemsCheat(
    session: GameConnection,
    request: GainAllCarItemsCheatRequest
) {
    session.sendResponse(GainAllCarItemsCheatResponse())
}