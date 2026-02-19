package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CarId
import moe.crx.roadblock.objects.account.CarUpgradeLevel
import moe.crx.roadblock.objects.account.FreeUpgrade
import moe.crx.roadblock.objects.inventory.CarStatType
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class FreeUpgradeCarStatLevelRequest(
    var carId: CarId,
    var carStat: CarStatType,
    var upgradeLevel: CarUpgradeLevel,
    var freeUpgrade: FreeUpgrade,
) : RequestPacket()

@Serializable
class FreeUpgradeCarStatLevelResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleFreeUpgradeCarStatLevel(
    session: GameConnection,
    request: FreeUpgradeCarStatLevelRequest
) {
    session.sendResponse(FreeUpgradeCarStatLevelResponse())
}