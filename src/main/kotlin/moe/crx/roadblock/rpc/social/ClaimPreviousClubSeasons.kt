package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
class ClaimPreviousClubSeasonsRequest : RequestPacket()

@Serializable
class ClaimPreviousClubSeasonsResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClaimPreviousClubSeasons(
    session: GameConnection,
    request: ClaimPreviousClubSeasonsRequest
) {
    session.sendResponse(ClaimPreviousClubSeasonsResponse())
}