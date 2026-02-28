package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.objects.EventTrackDefId
import moe.crx.roadblock.objects.RaceToken
import moe.crx.roadblock.objects.quarantine.RequiredPlaybackCondition
import moe.crx.roadblock.objects.quarantine.RequiredPlaybackDetailLevel
import moe.crx.roadblock.objects.settings.ControlSchemeType
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GauntletStartRaceRequest(
    var eventId: CalendarEventId,
    var trackDefId: EventTrackDefId,
    var raceId: UByte,
    var carId: CarId,
    var controlSchemeType: ControlSchemeType,
) : RequestPacket()

@Serializable
data class GauntletStartRaceResponse(
    var raceToken: RaceToken = 0u,
    var requiredPlaybackDetailLevel: RequiredPlaybackDetailLevel = RequiredPlaybackDetailLevel.OnlyPlayer,
    var requiredPlaybackCondition: RequiredPlaybackCondition = RequiredPlaybackCondition.Never,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGauntletStartRace(
    session: GameConnection,
    request: GauntletStartRaceRequest
) {
    session.sendResponse(GauntletStartRaceResponse())
}