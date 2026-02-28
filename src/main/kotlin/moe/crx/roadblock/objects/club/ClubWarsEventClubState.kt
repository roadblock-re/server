package moe.crx.roadblock.objects.club

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.ClubWarsPoints
import moe.crx.roadblock.objects.ClubWarsRoundIndex

@Serializable
data class ClubWarsEventClubState(
    var roundId: ClubWarsRoundIndex,
    var joinedTimestamp: Instant,
    var lastFinishedRoundIndex: ClubWarsRoundIndex,
    var eventScoreAfterLastFinishedRound: ClubWarsPoints,
)