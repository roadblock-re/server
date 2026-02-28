package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.social.CredentialAuthority
import moe.crx.roadblock.objects.social.Credentials
import moe.crx.roadblock.objects.social.UserCredentialsInfo
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class BatchFilterExistingUsersRequest(
    var filterAuthority: CredentialAuthority?,
    var credentialsList: List<Credentials>,
    var retrieveSocialProfile: Boolean,
) : RequestPacket()

@Serializable
data class BatchFilterExistingUsersResponse(
    var existingCredentialsList: List<UserCredentialsInfo> = listOf(),
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleBatchFilterExistingUsers(
    session: GameConnection,
    request: BatchFilterExistingUsersRequest
) {
    session.sendResponse(BatchFilterExistingUsersResponse())
}