package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
class MiscellaneousResetAdsReplacementStateRequest : RequestPacket()

@Serializable
class MiscellaneousResetAdsReplacementStateResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleMiscellaneousResetAdsReplacementState(
    session: GameConnection,
    request: MiscellaneousResetAdsReplacementStateRequest
) {
    session.sendResponse(MiscellaneousResetAdsReplacementStateResponse())
}