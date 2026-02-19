package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.ByteEnum
import moe.crx.roadblock.objects.account.AccountLinkingRequestOrigin
import moe.crx.roadblock.objects.account.CredentialAuthority
import moe.crx.roadblock.objects.account.Credentials
import moe.crx.roadblock.objects.social.SNSUserConflictData
import moe.crx.roadblock.objects.social.UserAccountInfo
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class LinkAccountWithCredentialRequest(
    var targetAccountCredential: Credentials,
    var ignoreLinkingIfAuthorityTypesExist: Set<CredentialAuthority>,
    @ByteEnum
    var requestOrigin: AccountLinkingRequestOrigin,
) : RequestPacket()

@Serializable
data class LinkAccountWithCredentialResponse(
    var isLinkingAutomaticallyCompleted: Boolean = false,
    var isLinkingIgnored: Boolean = false,
    var needGameRestart: Boolean = false,
    var accountLinkingInfo: UserAccountInfo? = null,
    var accountConflictData: SNSUserConflictData? = null,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleLinkAccountWithCredential(
    session: GameConnection,
    request: LinkAccountWithCredentialRequest
) {
    session.sendResponse(LinkAccountWithCredentialResponse())
}