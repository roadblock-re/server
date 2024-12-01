package moe.crx.roadblock.objects.game

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class PlatformCredentials : RObject {

    // ALU uses just struct, not list
    var credentials: List<Credentials> = listOf()

    override fun read(sink: InputSink) {
        credentials = sink.readList()
    }

    override fun write(sink: OutputSink) {
        sink.writeList(credentials)
    }
}