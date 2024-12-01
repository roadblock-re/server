package moe.crx.roadblock.objects.career

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class CareerChapterState : RObject {

    var chapterId: Int = 0
    var state: Int = 0
    var flags: Int = 0

    override fun read(sink: InputSink) {
        chapterId = sink.readInt()
        state = sink.readInt()
        flags = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(chapterId)
        sink.writeInt(state)
        sink.writeInt(flags)
    }
}