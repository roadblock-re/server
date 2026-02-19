package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.*
import moe.crx.roadblock.objects.settings.ControlSchemeType
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ClubRaceJoinRoomRequest(
    var encryptedServerRoomData: String,
    var carId: CarId,
    var snsCredential: Credentials?,
    var controlSchemeType: ControlSchemeType,
    var regionLatencyMap: Map<String, List<LatencySample>>?,
    var flowType: ClubRaceFlowType,
) : RequestPacket()

@Serializable
data class ClubRaceJoinRoomResponse(
    var requiredPlaybackDetailLevel: RequiredPlaybackDetailLevel = RequiredPlaybackDetailLevel.OnlyPlayer,
    var requiredPlaybackCondition: RequiredPlaybackCondition = RequiredPlaybackCondition.Never,
    var raceToken: RaceToken = 0u,
    var encryptedServerUserData: String = "",
    var clientUserData: String = "",
    var regionPreferences: List<RegionsPreferences>? = null,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClubRaceJoinRoom(
    session: GameConnection,
    request: ClubRaceJoinRoomRequest
) {
    session.sendResponse(ClubRaceJoinRoomResponse())
}