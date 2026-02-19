package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
class ClaimAllMissionRewardRequest : RequestPacket()

@Serializable
class ClaimAllMissionRewardResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClaimAllMissionReward(
    session: GameConnection,
    request: ClaimAllMissionRewardRequest
) {
    session.sendResponse(ClaimAllMissionRewardResponse())
}