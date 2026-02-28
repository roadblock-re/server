package moe.crx.roadblock.objects.social

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class ChatMessage(
    var message: MessageItem,
    var timestamp: Instant,
    var credentials: Credentials,
    var msgHash: ULong,
)