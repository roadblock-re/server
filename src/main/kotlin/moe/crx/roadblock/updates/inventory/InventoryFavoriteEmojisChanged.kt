package moe.crx.roadblock.updates.inventory

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RByte
import moe.crx.roadblock.objects.base.RObject

class InventoryFavoriteEmojisChanged : RObject {

    var favoriteEmojiIds: List<RByte> = listOf() // EmojiId

    override fun read(sink: InputSink) {
        favoriteEmojiIds = sink.readList()
    }

    override fun write(sink: OutputSink) {
        sink.writeList(favoriteEmojiIds)
    }
}