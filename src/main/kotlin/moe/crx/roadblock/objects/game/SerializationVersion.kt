package moe.crx.roadblock.objects.game

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class SerializationVersion : RObject {

    var major: Short = 0
    var minor: Short = 0
    var build: Short = 0

    override fun read(sink: InputSink) {
        major = sink.readShort()
        minor = sink.readShort()
        build = sink.readShort()
    }

    override fun write(sink: OutputSink) {
        sink.writeShort(major)
        sink.writeShort(minor)
        sink.writeShort(build)
    }
}