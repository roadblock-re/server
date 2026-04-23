package moe.crx.roadblock.objects.inventory

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.UntilVersion
import moe.crx.roadblock.objects.ConsecutiveDays
import moe.crx.roadblock.objects.RaceCount

@Serializable
data class CarUsageStats(
    var lastUsage: Instant? = null,
    var consecutiveDays: ConsecutiveDays? = null,
    var numRacesCareer: RaceCount = 0u,
    var numRacesMultiplayer: RaceCount = 0u,
    var numRacesTLE: RaceCount = 0u,
    @UntilVersion("24.6.0")
    var numRacesClubRace: RaceCount = 0u,
)