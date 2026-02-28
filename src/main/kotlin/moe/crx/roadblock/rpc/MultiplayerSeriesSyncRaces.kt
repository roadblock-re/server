package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.MultiplayerSeriesId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class MultiplayerSeriesSyncRacesRequest(
    var seriesId: MultiplayerSeriesId,
) : RequestPacket()

@Serializable
class MultiplayerSeriesSyncRacesResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleMultiplayerSeriesSyncRaces(
    session: GameConnection,
    request: MultiplayerSeriesSyncRacesRequest
) {
    session.sendResponse(MultiplayerSeriesSyncRacesResponse())
}