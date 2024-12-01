package moe.crx.roadblock.objects.game

import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class Error : RObject {

    var what: String = ""

    // Let's just hope that every error code enum is int.
    var code: Int = 0
    var innerError: Error? = null

    override fun read(sink: InputSink) {
        what = sink.readString()
        code = sink.readInt()
        innerError = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(what)
        sink.writeInt(code)
        sink.writeOptional(innerError)
    }
}