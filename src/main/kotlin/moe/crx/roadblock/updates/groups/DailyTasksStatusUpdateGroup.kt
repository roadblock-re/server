package moe.crx.roadblock.updates.groups

import moe.crx.roadblock.objects.base.RVariant
import moe.crx.roadblock.updates.dailytasks.*

class DailyTasksStatusUpdateGroup : RVariant(
    DailyTasksReseted::class,
    DailyTasksTaskUnlocked::class,
    DailyTasksTaskIncreased::class,
    DailyTasksTaskCompleted::class,
    DailyTasksTaskClaimed::class,
    DailyTasksTaskEnabled::class,
    DailyTasksRaceReadyCompleted::class,
    DailyTasksRaceReadyClaimed::class,
)