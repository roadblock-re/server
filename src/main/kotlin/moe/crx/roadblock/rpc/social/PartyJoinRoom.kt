package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.game.serialization.UntilVersion
import moe.crx.roadblock.objects.account.*
import moe.crx.roadblock.objects.party.PartyRacerData
import moe.crx.roadblock.objects.party.PartyReadyState
import moe.crx.roadblock.objects.party.PartyRoomData
import moe.crx.roadblock.objects.party.UserRole
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class PartyJoinRoomRequest(
    @UntilVersion("24.0.0")
    var encryptedServerRoomData: String = "",
    @UntilVersion("24.0.0")
    var legacyRacerData: PartyRacerData? = null,
    @FromVersion("24.0.0")
    var racerData: PartyRacerData = PartyRacerData(),
    @FromVersion("24.0.0")
    var userRole: UserRole = UserRole.Racer,
    @FromVersion("24.0.0")
    var roomAccessCode: PartyRoomAccessCode = "",
    @UntilVersion("24.0.0")
    var snsCredential: Credentials? = null,
    var regionLatencyMap: Map<String, List<LatencySample>>?,
    @FromVersion("24.0.0")
    var partyReadyState: PartyReadyState = PartyReadyState.NotReady,
) : RequestPacket()

@Serializable
data class PartyJoinRoomResponse(
    var requiredPlaybackDetailLevel: RequiredPlaybackDetailLevel = RequiredPlaybackDetailLevel.OnlyPlayer,
    var requiredPlaybackCondition: RequiredPlaybackCondition = RequiredPlaybackCondition.Never,
    var raceToken: RaceToken = 0u,
    @UntilVersion("24.0.0")
    var encryptedServerUserData: String = "",
    @UntilVersion("24.0.0")
    var clientUserData: String = "",
    @FromVersion("24.0.0")
    var privateLobbyRoomData: PartyRoomData = PartyRoomData(),
    var regionPreferences: List<RegionsPreferences>? = null,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handlePartyJoinRoom(
    session: GameConnection,
    request: PartyJoinRoomRequest
) {
    session.sendResponse(PartyJoinRoomResponse())
}