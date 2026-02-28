package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.dailytasks.DailyTaskType
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ClaimDailyTasksRequest(
    var tasksToClaim: List<DailyTaskType>,
    var willClaimMainTask: Boolean,
) : RequestPacket()

@Serializable
class ClaimDailyTasksResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClaimDailyTasks(
    session: GameConnection,
    request: ClaimDailyTasksRequest
) {
    session.sendResponse(ClaimDailyTasksResponse())
}