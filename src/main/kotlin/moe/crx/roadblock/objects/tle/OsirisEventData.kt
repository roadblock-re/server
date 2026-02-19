package moe.crx.roadblock.objects.tle

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.Blob
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.objects.account.CalendarEventVersion

@Serializable
data class OsirisEventData(
    var version: CalendarEventVersion,
    var eventId: CalendarEventId,
    var startDate: Instant,
    var endDate: Instant,
    var participationDate: Instant,
    var dbRawData: Blob?,
    var eTag: String?,
)