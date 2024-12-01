package moe.crx.roadblock.updates.career

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.ChapterId
import moe.crx.roadblock.objects.game.Flags

class CareerChapterFlagsChanged : RObject {

    var chapterId: ChapterId = 0
    var oldFlags: Flags = 0
    var newFlags: Flags = 0

    override fun read(sink: InputSink) {
        chapterId = sink.readInt()
        oldFlags = sink.readInt()
        newFlags = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(chapterId)
        sink.writeInt(oldFlags)
        sink.writeInt(newFlags)
    }
}