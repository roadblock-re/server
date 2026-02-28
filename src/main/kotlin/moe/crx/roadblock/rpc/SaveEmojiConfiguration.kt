package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.EmojiId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class SaveEmojiConfigurationRequest(
    var favoriteEmojis: List<EmojiId>,
    var muteEmojis: Boolean,
) : RequestPacket()

@Serializable
class SaveEmojiConfigurationResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleSaveEmojiConfiguration(
    session: GameConnection,
    request: SaveEmojiConfigurationRequest
) {
    session.sendResponse(SaveEmojiConfigurationResponse())
}