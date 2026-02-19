package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.ChatMessage
import moe.crx.roadblock.objects.account.RoomId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class SendChatMessageRequest(
    var roomName: RoomId,
    var message: ChatMessage,
) : RequestPacket()

@Serializable
class SendChatMessageResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleSendChatMessage(
    session: GameConnection,
    request: SendChatMessageRequest
) {
    session.sendResponse(SendChatMessageResponse())
}