package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.objects.CarUpgradeItemSlotId
import moe.crx.roadblock.objects.CarUpgradeLevel
import moe.crx.roadblock.objects.inventory.CarStatType
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class InstallUpgradeItemRequest(
    var carId: CarId,
    var statType: CarStatType,
    var upgradeLevel: CarUpgradeLevel,
    var upgradeSlot: CarUpgradeItemSlotId,
    @FromVersion("24.0.0")
    var eventId: CalendarEventId? = null,
    @FromVersion("45.0.0")
    var useWildcards: Boolean = false,
) : RequestPacket()

@Serializable
class InstallUpgradeItemResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleInstallUpgradeItem(
    session: GameConnection,
    request: InstallUpgradeItemRequest
) {
    session.sendResponse(InstallUpgradeItemResponse())
}