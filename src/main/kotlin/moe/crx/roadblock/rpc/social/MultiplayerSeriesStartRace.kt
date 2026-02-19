package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.RaceToken
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class MultiplayerSeriesStartRaceRequest(
    var raceToken: RaceToken,
) : RequestPacket()

@Serializable
data class MultiplayerSeriesStartRaceResponse(
    var gameplayServerLoginKey: ULong = 0u,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleMultiplayerSeriesStartRace(
    session: GameConnection,
    request: MultiplayerSeriesStartRaceRequest
) {
    session.sendResponse(MultiplayerSeriesStartRaceResponse())
}