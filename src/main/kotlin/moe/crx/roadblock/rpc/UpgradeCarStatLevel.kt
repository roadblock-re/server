package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.objects.CarUpgradeLevel
import moe.crx.roadblock.objects.inventory.CarStatType
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class UpgradeCarStatLevelRequest(
    var carId: CarId,
    var statType: CarStatType,
    var upgradeLevel: CarUpgradeLevel,
    var eventId: CalendarEventId?,
) : RequestPacket()

@Serializable
class UpgradeCarStatLevelResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleUpgradeCarStatLevel(
    session: GameConnection,
    request: UpgradeCarStatLevelRequest
) {
    session.sendResponse(UpgradeCarStatLevelResponse())
}