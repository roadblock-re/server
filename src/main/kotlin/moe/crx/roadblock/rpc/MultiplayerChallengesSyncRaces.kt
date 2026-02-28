package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.MultiplayerChallengesSeriesId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class MultiplayerChallengesSyncRacesRequest(
    var seriesId: MultiplayerChallengesSeriesId,
) : RequestPacket()

@Serializable
class MultiplayerChallengesSyncRacesResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleMultiplayerChallengesSyncRaces(
    session: GameConnection,
    request: MultiplayerChallengesSyncRacesRequest
) {
    session.sendResponse(MultiplayerChallengesSyncRacesResponse())
}