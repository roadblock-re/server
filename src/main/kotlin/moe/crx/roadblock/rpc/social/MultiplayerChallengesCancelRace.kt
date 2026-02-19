package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.RaceToken
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class MultiplayerChallengesCancelRaceRequest(
    var raceToken: RaceToken,
    var raceTimeMicroseconds: UInt,
) : RequestPacket()

@Serializable
class MultiplayerChallengesCancelRaceResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleMultiplayerChallengesCancelRace(
    session: GameConnection,
    request: MultiplayerChallengesCancelRaceRequest
) {
    session.sendResponse(MultiplayerChallengesCancelRaceResponse())
}