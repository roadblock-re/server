package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.RaceToken
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class MultiplayerChallengesFinishRaceRequest(
    var raceToken: RaceToken,
    var tryCount: UInt,
    var maxTries: UInt,
) : RequestPacket()

@Serializable
class MultiplayerChallengesFinishRaceResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleMultiplayerChallengesFinishRace(
    session: GameConnection,
    request: MultiplayerChallengesFinishRaceRequest
) {
    session.sendResponse(MultiplayerChallengesFinishRaceResponse())
}