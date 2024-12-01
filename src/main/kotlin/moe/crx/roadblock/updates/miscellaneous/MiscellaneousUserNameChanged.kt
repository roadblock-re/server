package moe.crx.roadblock.updates.miscellaneous

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class MiscellaneousUserNameChanged : RObject {

    var oldUsername: String = ""
    var newUsername: String = ""

    override fun read(sink: InputSink) {
        oldUsername = sink.readString()
        newUsername = sink.readString()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(oldUsername)
        sink.writeString(newUsername)
    }
}