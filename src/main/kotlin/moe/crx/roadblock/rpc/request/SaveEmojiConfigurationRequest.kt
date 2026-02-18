package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RByte
import moe.crx.roadblock.rpc.base.RequestPacket

class SaveEmojiConfigurationRequest : RequestPacket() {

    var selectedEmojis: List<RByte> = listOf()
    var areEmojisDisabled: Boolean = false

    override fun read(sink: InputSink) {
        super.read(sink)
        selectedEmojis = sink.readList()
        areEmojisDisabled = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeList(selectedEmojis)
        sink.writeBoolean(areEmojisDisabled)
    }
}