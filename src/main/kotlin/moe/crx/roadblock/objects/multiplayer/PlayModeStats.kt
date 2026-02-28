package moe.crx.roadblock.objects.multiplayer

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.Money

@Serializable
sealed class PlayModeStats {
    companion object : Variant<PlayModeStats> {
        override fun variants(version: SerializationVersion) = buildList {
            add(TimeAttackStats::class)
            add(LapBasedStats::class)
            add(ChaseStats::class)
            add(MoneyRunStats::class)
            add(TakedownStats::class)
            add(MultiplayerTakedownStats::class)
        }
    }
}

@Serializable
data class TimeAttackStats(
    var timeLeft: UInt,
    var highestCheckpointReached: UInt,
    var hasFinishedRace: Boolean
) : PlayModeStats()

@Serializable
data class LapBasedStats(
    var isDisqualified: Boolean
) : PlayModeStats()

@Serializable
data class ChaseStats(
    var timeLeft: UInt,
    var hasEscaped: Boolean
) : PlayModeStats()

@Serializable
data class MoneyRunStats(
    var isDisqualified: Boolean,
    var achievedMoney: Money,
    var hasEnoughMoney: Boolean
) : PlayModeStats()

@Serializable
data class TakedownStats(
    var hasCompletedRace: Boolean,
    var eliminatedVictims: UInt,
    var remainingTime: UInt,
    var isPolice: Boolean,
    var remainingLives: UByte
) : PlayModeStats()

@Serializable
data class MultiplayerTakedownStats(
    var playerStats: TakedownStats,
    var didPoliceWin: Boolean,
    var requiredTakedowns: UInt,
    var totalTakedowns: UInt
) : PlayModeStats()