package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.UntilVersion
import moe.crx.roadblock.objects.ClubId
import moe.crx.roadblock.objects.ClubRequestId
import moe.crx.roadblock.objects.social.OnlineUserData
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class AcceptClubRequestRequest(
    var clubId: ClubId,
    var requestId: ClubRequestId,
    @UntilVersion("47.1.0")
    var debugSuffix: String = "",
) : RequestPacket()

@Serializable
data class AcceptClubRequestResponse(
    var memberData: OnlineUserData
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleAcceptClubRequest(
    session: GameConnection,
    request: AcceptClubRequestRequest
) {
    TODO()
}