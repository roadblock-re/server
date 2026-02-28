package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.UntilVersion
import moe.crx.roadblock.objects.ClubId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class RequestJoinClubRequest(
    var clubId: ClubId,
    var clubName: String,
    @UntilVersion("47.1.0")
    var debugSuffix: String = "",
) : RequestPacket()

@Serializable
class RequestJoinClubResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleRequestJoinClub(
    session: GameConnection,
    request: RequestJoinClubRequest
) {
    session.sendResponse(RequestJoinClubResponse())
}