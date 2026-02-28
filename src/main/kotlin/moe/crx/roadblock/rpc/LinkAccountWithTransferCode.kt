package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.miscellaneous.TransferCode
import moe.crx.roadblock.objects.social.SNSUserConflictData
import moe.crx.roadblock.objects.social.UserAccountInfo
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class LinkAccountWithTransferCodeRequest(
    var transferCode: TransferCode,
) : RequestPacket()

@Serializable
data class LinkAccountWithTransferCodeResponse(
    var isLinkingAutomaticallyCompleted: Boolean = false,
    var accountLinkingInfo: UserAccountInfo? = null,
    var accountConflictData: SNSUserConflictData? = null,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleLinkAccountWithTransferCode(
    session: GameConnection,
    request: LinkAccountWithTransferCodeRequest
) {
    session.sendResponse(LinkAccountWithTransferCodeResponse())
}