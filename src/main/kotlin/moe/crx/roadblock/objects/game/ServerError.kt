package moe.crx.roadblock.objects.game

import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class ServerError : RObject {

    var code: Int = 0
    var what: String = ""
    var innerError: ServerError? = null

    override fun read(sink: InputSink) {
        code = sink.readInt()
        what = sink.readString()
        innerError = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(code)
        sink.writeString(what)
        sink.writeOptional(innerError)
    }
}