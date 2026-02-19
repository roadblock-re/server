package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.ByteEnum
import moe.crx.roadblock.objects.account.AccountLinkingRequestOrigin
import moe.crx.roadblock.objects.account.Credentials
import moe.crx.roadblock.objects.social.UserAccountInfo
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ConfirmLinkingOperationRequest(
    var accountToLinkCredential: Credentials,
    var keepCurrentAccountProgress: Boolean,
    @ByteEnum
    var requestOrigin: AccountLinkingRequestOrigin,
) : RequestPacket()

@Serializable
data class ConfirmLinkingOperationResponse(
    var needGameRestart: Boolean = false,
    var accountLinkingInfo: UserAccountInfo,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleConfirmLinkingOperation(
    session: GameConnection,
    request: ConfirmLinkingOperationRequest
) {
    TODO()
}