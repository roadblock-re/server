package moe.crx.roadblock.objects.models

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.RaceToken
import moe.crx.roadblock.objects.mpchallenges.MultiplayerChallenge

@Serializable
data class MultiplayerChallengesState(
    var eventDataById: Map<CalendarEventId, MultiplayerChallenge> = mapOf(),
    var currentEventId: CalendarEventId = "",
    var alreadyProcessedRaceTokenTransactions: List<RaceToken> = listOf(),
)