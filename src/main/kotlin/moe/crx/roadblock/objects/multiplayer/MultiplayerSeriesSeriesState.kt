package moe.crx.roadblock.objects.multiplayer

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.objects.account.PlayerElo

@Serializable
data class MultiplayerSeriesSeriesState(
    var eloOfLastClosedEvent: PlayerElo?,
    @FromVersion("24.6.0")
    var lastClosedEventTimepoint: Instant? = null,
    var currentEventId: CalendarEventId,
    var eventDataById: Map<CalendarEventId, MultiplayerSeriesEventState>,
)