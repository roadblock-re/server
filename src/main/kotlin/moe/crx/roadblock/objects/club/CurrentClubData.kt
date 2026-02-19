package moe.crx.roadblock.objects.club

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.objects.account.ClubId
import moe.crx.roadblock.objects.account.ReputationPoints

@Serializable
data class CurrentClubData(
    var id: ClubId,
    var joinedEventId: CalendarEventId,
    var originalReputation: ReputationPoints,
    var cachedInfo: CachedClubInfo,
)