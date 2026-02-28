package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
class MultiplayerSeriesRequestRevertOfMaintenanceBookingRequest : RequestPacket()

@Serializable
class MultiplayerSeriesRequestRevertOfMaintenanceBookingResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleMultiplayerSeriesRequestRevertOfMaintenanceBooking(
    session: GameConnection,
    request: MultiplayerSeriesRequestRevertOfMaintenanceBookingRequest
) {
    session.sendResponse(MultiplayerSeriesRequestRevertOfMaintenanceBookingResponse())
}