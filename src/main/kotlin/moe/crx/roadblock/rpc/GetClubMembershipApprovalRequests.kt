package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.club.MembershipRequest
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GetClubMembershipApprovalRequestsRequest(
    var maxCount: UInt,
    var shouldGetRejected: Boolean,
) : RequestPacket()

@Serializable
data class GetClubMembershipApprovalRequestsResponse(
    var requests: List<MembershipRequest> = listOf(),
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGetClubMembershipApprovalRequests(
    session: GameConnection,
    request: GetClubMembershipApprovalRequestsRequest
) {
    session.sendResponse(GetClubMembershipApprovalRequestsResponse())
}