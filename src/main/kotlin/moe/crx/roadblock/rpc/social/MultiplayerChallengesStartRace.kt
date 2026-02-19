package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.RaceToken
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class MultiplayerChallengesStartRaceRequest(
    var raceToken: RaceToken,
) : RequestPacket()

@Serializable
data class MultiplayerChallengesStartRaceResponse(
    var gameplayServerLoginKey: ULong = 0u,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleMultiplayerChallengesStartRace(
    session: GameConnection,
    request: MultiplayerChallengesStartRaceRequest
) {
    session.sendResponse(MultiplayerChallengesStartRaceResponse())
}