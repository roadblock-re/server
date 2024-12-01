package moe.crx.roadblock.objects.game

import moe.crx.roadblock.objects.base.RVariant
import moe.crx.roadblock.objects.stats.*

class PlayModeStats : RVariant(
    TimeAttackStats::class,
    LapBasedStats::class,
    ChaseStats::class,
    MoneyRunStats::class,
    TakedownStats::class,
    MultiplayerTakedownStats::class,
)