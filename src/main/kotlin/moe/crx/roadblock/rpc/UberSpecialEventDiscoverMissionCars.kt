package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.UberTierId
import moe.crx.roadblock.objects.uber.UberPoolMissionId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class UberSpecialEventDiscoverMissionCarsRequest(
    var eventId: CalendarEventId,
    var tierId: UberTierId,
    var poolMissionId: UberPoolMissionId,
) : RequestPacket()

@Serializable
class UberSpecialEventDiscoverMissionCarsResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleUberSpecialEventDiscoverMissionCars(
    session: GameConnection,
    request: UberSpecialEventDiscoverMissionCarsRequest
) {
    session.sendResponse(UberSpecialEventDiscoverMissionCarsResponse())
}