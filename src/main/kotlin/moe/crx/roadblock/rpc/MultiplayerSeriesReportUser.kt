package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.social.Credentials
import moe.crx.roadblock.objects.RaceToken
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class MultiplayerSeriesReportUserRequest(
    var raceToken: RaceToken,
    var reportedCredential: Credentials,
    var reasons: UByte,
    var moreDetails: String,
) : RequestPacket()

@Serializable
class MultiplayerSeriesReportUserResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleMultiplayerSeriesReportUser(
    session: GameConnection,
    request: MultiplayerSeriesReportUserRequest
) {
    session.sendResponse(MultiplayerSeriesReportUserResponse())
}