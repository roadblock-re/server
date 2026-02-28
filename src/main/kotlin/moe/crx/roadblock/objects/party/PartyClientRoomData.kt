package moe.crx.roadblock.objects.party

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.EventTrackDefId
import moe.crx.roadblock.objects.inventory.CarClass

@Serializable
data class PartyClientRoomData(
    var eventId: CalendarEventId = "",
    var laps: UInt = 0u,
    var maxCarClass: CarClass = CarClass.S,
    var eventTrackDef: EventTrackDefId = 0u,
    var creatorName: String = "",
    var creatorId: String = "",
    var creationTime: Instant = now(),
    var launchCount: UInt = 0u,
)