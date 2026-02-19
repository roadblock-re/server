package moe.crx.roadblock.objects.models

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.dailytasks.DailyTask
import moe.crx.roadblock.objects.dailytasks.DailyTaskState

@Serializable
data class DailyTasksState(
    var state: DailyTaskState = DailyTaskState(),
    var dailyTasks: List<DailyTask> = buildList {
        repeat(10) { // Yeah, it should be 10. Why? I have no idea.
            add(
                DailyTask(
                    // Play any race and upgrade cars
                    isLocked = it != 1 && it != 2
                )
            )
        }
    },
)