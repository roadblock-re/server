package moe.crx.roadblock.objects.club

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.ClubWarsPoints
import moe.crx.roadblock.objects.account.ClubWarsRoundIndex

@Serializable
data class ClubWarsEventParticipation(
    var score: ClubWarsPoints,
    var currentRoundIndex: ClubWarsRoundIndex,
    var joinTimestamp: Instant,
    var eventScoreAfterLastFinishedRound: ClubWarsPoints,
    var lastFinishedRoundIndex: ClubWarsRoundIndex,
)