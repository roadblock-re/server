package moe.crx.roadblock.objects.gauntlet

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.objects.CarRank

@Serializable
data class GauntletRaceStats(
    var time: Instant,
    var carId: CarId,
    var carRank: CarRank,
    var isOverclocked: Boolean,
)