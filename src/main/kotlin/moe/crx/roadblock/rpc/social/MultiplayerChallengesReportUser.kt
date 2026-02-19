package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.Credentials
import moe.crx.roadblock.objects.account.RaceToken
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class MultiplayerChallengesReportUserRequest(
    var raceToken: RaceToken,
    var reportedCredential: Credentials,
    var reasons: UByte,
    var moreDetails: String,
) : RequestPacket()

@Serializable
class MultiplayerChallengesReportUserResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleMultiplayerChallengesReportUser(
    session: GameConnection,
    request: MultiplayerChallengesReportUserRequest
) {
    session.sendResponse(MultiplayerChallengesReportUserResponse())
}