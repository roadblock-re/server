package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.*
import moe.crx.roadblock.objects.clubwars.ClubWarsNodeId
import moe.crx.roadblock.objects.settings.ControlSchemeType
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ClubWarsDefenseStartRaceRequest(
    var eventId: CalendarEventId,
    var nodeId: ClubWarsNodeId,
    var carId: CarId,
    var controlSchemeType: ControlSchemeType,
) : RequestPacket()

@Serializable
data class ClubWarsDefenseStartRaceResponse(
    var raceToken: RaceToken = 0u,
    var requiredPlaybackDetailLevel: RequiredPlaybackDetailLevel = RequiredPlaybackDetailLevel.OnlyPlayer,
    var requiredPlaybackCondition: RequiredPlaybackCondition = RequiredPlaybackCondition.Never,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClubWarsDefenseStartRace(
    session: GameConnection,
    request: ClubWarsDefenseStartRaceRequest
) {
    session.sendResponse(ClubWarsDefenseStartRaceResponse())
}