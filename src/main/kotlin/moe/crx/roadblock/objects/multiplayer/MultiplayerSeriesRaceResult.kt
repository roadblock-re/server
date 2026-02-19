package moe.crx.roadblock.objects.multiplayer

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.*
import moe.crx.roadblock.objects.settings.ControlSchemeType

@Serializable
data class MultiplayerSeriesRaceResult(
    var seriesId: MultiplayerSeriesId,
    var eventId: CalendarEventId,
    var raceConfigId: MultiplayerRaceConfigId,
    var raceToken: RaceToken,
    var carId: CarId,
    var eventCar: EventCarInfo?,
    var raceStats: RaceStats,
    var finishReason: MultiplayerSeriesFinishRaceReason,
    var eloByFinishPosition: List<PlayerElo>,
    var gameplayServerCreationTime: Instant,
    var raceFinishServerTime: Instant,
    var disconnectionPenaltyStrength: Float,
    var controlSchemeType: ControlSchemeType,
)