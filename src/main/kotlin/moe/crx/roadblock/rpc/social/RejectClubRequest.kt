package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.ClubId
import moe.crx.roadblock.objects.account.ClubRequestId
import moe.crx.roadblock.objects.account.Credentials
import moe.crx.roadblock.objects.social.RejectRequestMode
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class RejectClubRequestRequest(
    var clubId: ClubId,
    var requestId: ClubRequestId,
    var requesterCredentials: Credentials,
    var requesterName: String,
    var rejectionMode: RejectRequestMode,
) : RequestPacket()

@Serializable
class RejectClubRequestResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleRejectClubRequest(
    session: GameConnection,
    request: RejectClubRequestRequest
) {
    session.sendResponse(RejectClubRequestResponse())
}