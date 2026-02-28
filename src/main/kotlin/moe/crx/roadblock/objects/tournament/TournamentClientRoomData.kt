package moe.crx.roadblock.objects.tournament

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.objects.EventTrackDefId
import moe.crx.roadblock.objects.inventory.CarClass

@Serializable
data class TournamentClientRoomData(
    var eventId: CalendarEventId = "",
    var laps: UInt = 0u,
    var maxCarClass: CarClass = CarClass.S,
    var eventTrackDef: EventTrackDefId = 0u,
    var creatorName: String = "",
    var creatorId: String = "",
    var creationTime: Instant = now(),
    var launchCount: UInt = 0u,
    var gameMode: UInt,
    var carContact: CarId,
    var ghostTime: ULong?,
    var psMatchId: String?,
    var isMatchCancelledByOwner: Boolean,
)