package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.Credentials
import moe.crx.roadblock.objects.social.UserCredentialsInfo
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GetCredentialsForConsoleUsersRequest(
    var allConsoleFriends: List<Credentials>,
    var unknownCredentials: List<Credentials>,
) : RequestPacket()

@Serializable
data class GetCredentialsForConsoleUsersResponse(
    var existingCredentialsList: List<UserCredentialsInfo> = listOf()
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGetCredentialsForConsoleUsers(
    session: GameConnection,
    request: GetCredentialsForConsoleUsersRequest
) {
    session.sendResponse(GetCredentialsForConsoleUsersResponse())
}