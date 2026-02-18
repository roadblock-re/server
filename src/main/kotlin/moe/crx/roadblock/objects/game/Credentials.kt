package moe.crx.roadblock.objects.game

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class Credentials : RObject {

    var username: String = ""

    override fun read(sink: InputSink) {
        username = sink.readString()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(username)
    }
}