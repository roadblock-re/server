package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.objects.social.Credentials
import moe.crx.roadblock.objects.RaceToken
import moe.crx.roadblock.objects.StatusUpdatesQueueWithRootReactions
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.ResponsePacket

@Serializable
data class ReportUserRequest(
    var raceToken: RaceToken,
    var reportedCredential: Credentials,
    var reasons: UByte,
    var moreDetails: String,
    @FromVersion("47.1.0")
    var reportUserSource: UInt = 0u,
    @FromVersion("47.1.0")
    var blockUser: Boolean = false,
) : RequestPacket()

@Serializable
data class ReportUserResponse(
    @FromVersion("47.1.0")
    var didBlock: Boolean = false,
    @FromVersion("47.1.0")
    var didRejectFriendRequest: Boolean? = null,
    @FromVersion("47.1.0")
    var didCancelSentRequest: Boolean? = null,
    var updatesQueue: StatusUpdatesQueueWithRootReactions = StatusUpdatesQueueWithRootReactions(),
) : ResponsePacket()

suspend fun handleReportUser(
    session: GameConnection,
    request: ReportUserRequest
) {
    session.sendResponse(ReportUserResponse())
}