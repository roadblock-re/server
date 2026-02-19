package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.objects.account.GauntletScore
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GauntletUpdatePendingDataAndActionsRequest(
    var eventId: CalendarEventId,
    var lbScore: GauntletScore,
) : RequestPacket()

@Serializable
data class GauntletUpdatePendingDataAndActionsResponse(
    var shouldRefreshLeaderboard: Boolean = false,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGauntletUpdatePendingDataAndActions(
    session: GameConnection,
    request: GauntletUpdatePendingDataAndActionsRequest
) {
    session.sendResponse(GauntletUpdatePendingDataAndActionsResponse())
}