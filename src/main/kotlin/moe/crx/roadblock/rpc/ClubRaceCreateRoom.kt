package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.objects.ClubRaceEventId
import moe.crx.roadblock.objects.RaceToken
import moe.crx.roadblock.objects.clubrace.ClubRaceFlowType
import moe.crx.roadblock.objects.multiplayer.LatencySample
import moe.crx.roadblock.objects.multiplayer.RegionsPreferences
import moe.crx.roadblock.objects.quarantine.RequiredPlaybackCondition
import moe.crx.roadblock.objects.quarantine.RequiredPlaybackDetailLevel
import moe.crx.roadblock.objects.settings.ControlSchemeType
import moe.crx.roadblock.objects.social.Credentials
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ClubRaceCreateRoomRequest(
    var eventId: ClubRaceEventId,
    var laps: UInt,
    var carId: CarId,
    var snsCredential: Credentials?,
    var controlSchemeType: ControlSchemeType,
    var regionLatencyMap: Map<String, List<LatencySample>>?,
    var flowType: ClubRaceFlowType,
) : RequestPacket()

@Serializable
data class ClubRaceCreateRoomResponse(
    var requiredPlaybackDetailLevel: RequiredPlaybackDetailLevel = RequiredPlaybackDetailLevel.OnlyPlayer,
    var requiredPlaybackCondition: RequiredPlaybackCondition = RequiredPlaybackCondition.Never,
    var raceToken: RaceToken = 0u,
    var encryptedServerUserData: String = "",
    var encryptedServerRoomData: String = "",
    var clientUserData: String = "",
    var clientRoomData: String = "",
    var filter: String = "",
    var regionPreferences: List<RegionsPreferences>? = null
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClubRaceCreateRoom(
    session: GameConnection,
    request: ClubRaceCreateRoomRequest
) {
    session.sendResponse(ClubRaceCreateRoomResponse())
}