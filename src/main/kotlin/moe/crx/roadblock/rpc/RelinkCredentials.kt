package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.ByteEnum
import moe.crx.roadblock.objects.social.Credentials
import moe.crx.roadblock.objects.miscellaneous.AccountLinkingRequestOrigin
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class RelinkCredentialsRequest(
    var targetFederationId: Credentials,
    var credentialsToRelink: Credentials,
    @ByteEnum
    var requestOrigin: AccountLinkingRequestOrigin,
) : RequestPacket()

@Serializable
class RelinkCredentialsResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleRelinkCredentials(
    session: GameConnection,
    request: RelinkCredentialsRequest
) {
    session.sendResponse(RelinkCredentialsResponse())
}