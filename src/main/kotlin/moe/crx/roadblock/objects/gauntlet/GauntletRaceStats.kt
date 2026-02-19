package moe.crx.roadblock.objects.gauntlet

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.CarId
import moe.crx.roadblock.objects.account.CarRank

@Serializable
data class GauntletRaceStats(
    var time: Instant,
    var carId: CarId,
    var carRank: CarRank,
    var isOverclocked: Boolean,
)