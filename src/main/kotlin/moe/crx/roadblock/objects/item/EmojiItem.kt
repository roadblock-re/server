package moe.crx.roadblock.objects.item

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class EmojiItem : RObject {

    var emojiId: Byte = 0

    override fun read(sink: InputSink) {
        emojiId = sink.readByte()
    }

    override fun write(sink: OutputSink) {
        sink.writeByte(emojiId)
    }
}