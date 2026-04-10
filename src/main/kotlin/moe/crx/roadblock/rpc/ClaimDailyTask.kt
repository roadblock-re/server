package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.dailytasks.DailyTaskType
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ClaimDailyTaskRequest(
    var task: DailyTaskType,
) : RequestPacket()

@Serializable
class ClaimDailyTaskResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClaimDailyTask(
    session: GameConnection,
    request: ClaimDailyTaskRequest
) {
    session.sendResponse(ClaimDailyTaskResponse())
}