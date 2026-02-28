package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.objects.social.Credentials
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ClaimDynamicRewardRequest(
    var templateId: String,
    var sourceCredential: Credentials?,
    @FromVersion("47.1.0")
    var isDeepLinkingReward: Boolean = false,
) : RequestPacket()

@Serializable
class ClaimDynamicRewardResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClaimDynamicReward(
    session: GameConnection,
    request: ClaimDynamicRewardRequest
) {
    session.sendResponse(ClaimDynamicRewardResponse())
}