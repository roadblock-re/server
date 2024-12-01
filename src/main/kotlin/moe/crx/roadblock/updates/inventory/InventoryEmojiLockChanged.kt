package moe.crx.roadblock.updates.inventory

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.EmojiId

class InventoryEmojiLockChanged : RObject {

    var emojiId: EmojiId = 0
    var isLocked: Boolean = false

    override fun read(sink: InputSink) {
        emojiId = sink.readByte()
        isLocked = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeByte(emojiId)
        sink.writeBoolean(isLocked)
    }
}