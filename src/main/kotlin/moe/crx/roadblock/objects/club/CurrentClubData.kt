package moe.crx.roadblock.objects.club

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.ClubId
import moe.crx.roadblock.objects.ReputationPoints

@Serializable
data class CurrentClubData(
    var id: ClubId,
    var joinedEventId: CalendarEventId,
    var originalReputation: ReputationPoints,
    var cachedInfo: CachedClubInfo,
)