package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.objects.CarUpgradeTier
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class UnlockUpgradeTierRequest(
    var carId: CarId,
    var tier: CarUpgradeTier,
) : RequestPacket()

@Serializable
class UnlockUpgradeTierResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleUnlockUpgradeTier(
    session: GameConnection,
    request: UnlockUpgradeTierRequest
) {
    session.sendResponse(UnlockUpgradeTierResponse())
}