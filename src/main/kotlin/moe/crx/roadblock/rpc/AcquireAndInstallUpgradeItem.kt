package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.objects.CarUpgradeItemSlotId
import moe.crx.roadblock.objects.CarUpgradeLevel
import moe.crx.roadblock.objects.inventory.CarStatType
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class AcquireAndInstallUpgradeItemRequest(
    var carId: CarId,
    var carStatType: CarStatType,
    var upgradeLevel: CarUpgradeLevel,
    var upgradeSlot: CarUpgradeItemSlotId,
) : RequestPacket()

@Serializable
class AcquireAndInstallUpgradeItemResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleAcquireAndInstallUpgradeItem(
    session: GameConnection,
    request: AcquireAndInstallUpgradeItemRequest
) {
    session.sendResponse(AcquireAndInstallUpgradeItemResponse())
}