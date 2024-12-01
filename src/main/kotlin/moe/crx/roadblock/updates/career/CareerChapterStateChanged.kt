package moe.crx.roadblock.updates.career

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.ChapterId
import moe.crx.roadblock.objects.game.ProgressState

class CareerChapterStateChanged : RObject {

    var eventId: ChapterId = 0
    var oldState: ProgressState = ProgressState.Locked
    var newState: ProgressState = ProgressState.Locked

    override fun read(sink: InputSink) {
        eventId = sink.readInt()
        oldState = sink.readEnum()
        newState = sink.readEnum()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(eventId)
        sink.writeEnum(oldState)
        sink.writeEnum(newState)
    }
}