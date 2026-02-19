package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
class ClubWarsMarketRefreshRequest : RequestPacket()

@Serializable
class ClubWarsMarketRefreshResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClubWarsMarketRefresh(
    session: GameConnection,
    request: ClubWarsMarketRefreshRequest
) {
    session.sendResponse(ClubWarsMarketRefreshResponse())
}