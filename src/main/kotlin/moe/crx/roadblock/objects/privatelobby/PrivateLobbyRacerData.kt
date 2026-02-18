package moe.crx.roadblock.objects.privatelobby

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class PrivateLobbyRacerData : RObject {

    // TODO
    var int1: Int = 0
    var int2: Int = 0

    override fun read(sink: InputSink) {
        int1 = sink.readInt()
        int2 = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(int1)
        sink.writeInt(int2)
    }
}