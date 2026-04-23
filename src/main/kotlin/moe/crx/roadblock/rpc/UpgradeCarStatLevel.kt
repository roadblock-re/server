package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.objects.CarUpgradeLevel
import moe.crx.roadblock.objects.inventory.CarStatType
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse
import moe.crx.roadblock.rpc.base.flatten
import moe.crx.roadblock.updates.InventoryCarUpgradeLevelChanged

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
    val car = session.gameState.inventory.cars[request.carId]
    checkNotNull(car)

    val stat = car.carTuning.stats[request.statType]
    stat.currentUpgradeLevel++

    val reaction = InventoryCarUpgradeLevelChanged(
        carId = request.carId,
        carStat = request.statType,
        oldLevel = request.upgradeLevel,
        newLevel = stat.currentUpgradeLevel,
    )

    // TODO spend money from wallet

    session.sendResponse(UpgradeCarStatLevelResponse().flatten(reaction))
}