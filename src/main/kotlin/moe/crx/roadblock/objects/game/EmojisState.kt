package moe.crx.roadblock.objects.game

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RByte
import moe.crx.roadblock.objects.base.RObject

class EmojisState : RObject {

    var unlockedEmojis: List<RByte> = listOf()
    var selectedEmojis: List<RByte> = listOf()
    var areEmojisDisabled: Boolean = false

    override fun read(sink: InputSink) {
        unlockedEmojis = sink.readList()
        selectedEmojis = sink.readList()
        areEmojisDisabled = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeList(unlockedEmojis)
        sink.writeList(selectedEmojis)
        sink.writeBoolean(areEmojisDisabled)
    }
}