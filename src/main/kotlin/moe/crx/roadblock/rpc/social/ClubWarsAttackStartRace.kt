package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.*
import moe.crx.roadblock.objects.clubwars.ClubWarsNodeId
import moe.crx.roadblock.objects.settings.ControlSchemeType
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ClubWarsAttackStartRaceRequest(
    var eventId: CalendarEventId,
    var nodeId: ClubWarsNodeId,
    var carId: CarId,
    var controlSchemeType: ControlSchemeType,
    var debugSuffix: String,
) : RequestPacket()

@Serializable
data class ClubWarsAttackStartRaceResponse(
    var raceToken: RaceToken = 0u,
    var requiredPlaybackDetailLevel: RequiredPlaybackDetailLevel = RequiredPlaybackDetailLevel.OnlyPlayer,
    var requiredPlaybackCondition: RequiredPlaybackCondition = RequiredPlaybackCondition.Never,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClubWarsAttackStartRace(
    session: GameConnection,
    request: ClubWarsAttackStartRaceRequest
) {
    session.sendResponse(ClubWarsAttackStartRaceResponse())
}