package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
class DailyTasksResetRequest : RequestPacket()

@Serializable
class DailyTasksResetResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleDailyTasksReset(
    session: GameConnection,
    request: DailyTasksResetRequest
) {
    session.sendResponse(DailyTasksResetResponse())
}