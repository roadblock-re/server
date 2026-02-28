package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
class ClaimEnableNotificationsRewardRequest : RequestPacket()

@Serializable
class ClaimEnableNotificationsRewardResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClaimEnableNotificationsReward(
    session: GameConnection,
    request: ClaimEnableNotificationsRewardRequest
) {
    session.sendResponse(ClaimEnableNotificationsRewardResponse())
}