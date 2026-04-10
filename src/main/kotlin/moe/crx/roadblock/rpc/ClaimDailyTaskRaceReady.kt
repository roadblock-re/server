package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
class ClaimDailyTaskRaceReadyRequest : RequestPacket()

@Serializable
class ClaimDailyTaskRaceReadyResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClaimDailyTaskRaceReady(
    session: GameConnection,
    request: ClaimDailyTaskRaceReadyRequest
) {
    session.sendResponse(ClaimDailyTaskRaceReadyResponse())
}