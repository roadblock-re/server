package moe.crx.roadblock.objects.game

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class PingAddress : RObject {

    var host: String = ""
    var port: Int = 0

    override fun read(sink: InputSink) {
        host = sink.readString()
        port = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(host)
        sink.writeInt(port)
    }

}
