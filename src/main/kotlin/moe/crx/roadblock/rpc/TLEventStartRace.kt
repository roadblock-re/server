package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.objects.EventTrackDefId
import moe.crx.roadblock.objects.RaceToken
import moe.crx.roadblock.objects.quarantine.RequiredPlaybackCondition
import moe.crx.roadblock.objects.quarantine.RequiredPlaybackDetailLevel
import moe.crx.roadblock.objects.settings.ControlSchemeType
import moe.crx.roadblock.objects.tle.TLEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class TLEventStartRaceRequest(
    var eventId: TLEventId,
    var carId: CarId,
    var controlScheme: ControlSchemeType,
) : RequestPacket()

@Serializable
data class TLEventStartRaceResponse(
    var raceId: RaceToken = 0u,
    var playbackDetailLevel: RequiredPlaybackDetailLevel = RequiredPlaybackDetailLevel.OnlyPlayer,
    var playbackCondition: RequiredPlaybackCondition = RequiredPlaybackCondition.Never,
    var requiredPlaybackRaceTimeToBeatMicroseconds: UInt? = null,
    @FromVersion("47.1.0")
    var eventTrackDefId: EventTrackDefId = 0u,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleTLEventStartRace(
    session: GameConnection,
    request: TLEventStartRaceRequest
) {
    session.sendResponse(TLEventStartRaceResponse())
}