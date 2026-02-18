package moe.crx.roadblock.objects.models

import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.dailytasks.DailyTask
import moe.crx.roadblock.objects.dailytasks.DailyTaskState

class DailyTasksState : RObject {

    var dailyTaskState: DailyTaskState = DailyTaskState()
    var dailyTasks: List<DailyTask> = listOf()

    override fun read(sink: InputSink) {
        dailyTaskState = sink.readObject()
        dailyTasks = sink.readList()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(dailyTaskState)
        sink.writeList(dailyTasks)
    }
}