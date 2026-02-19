package moe.crx.roadblock.objects.inventory

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.EmojiId

@Serializable
data class EmojisState(
    var unlockedEmojis: List<EmojiId> = listOf(),
    var selectedEmojis: List<EmojiId> = listOf(),
    var muteEmojis: Boolean = false,
)