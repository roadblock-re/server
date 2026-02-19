package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.InboxMessageId
import moe.crx.roadblock.objects.account.InboxProviderType
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class InboxMarkAsReadRequest(
    var messageId: InboxMessageId,
    var providerType: InboxProviderType,
) : RequestPacket()

@Serializable
class InboxMarkAsReadResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleInboxMarkAsRead(
    session: GameConnection,
    request: InboxMarkAsReadRequest
) {
    session.sendResponse(InboxMarkAsReadResponse())
}