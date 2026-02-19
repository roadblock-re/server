package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.*
import moe.crx.roadblock.objects.settings.ControlSchemeType
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class CareerStartRaceRequest(
    var eventId: CareerEventId,
    var carId: CarId,
    var controlScheme: ControlSchemeType,
) : RequestPacket()

@Serializable
data class CareerStartRaceResponse(
    var raceId: RaceToken = 0u,
    var playbackDetailLevel: RequiredPlaybackDetailLevel = RequiredPlaybackDetailLevel.OnlyPlayer,
    var playbackCondition: RequiredPlaybackCondition = RequiredPlaybackCondition.Never,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleCareerStartRace(
    session: GameConnection,
    request: CareerStartRaceRequest
) {
    session.sendResponse(CareerStartRaceResponse())
}