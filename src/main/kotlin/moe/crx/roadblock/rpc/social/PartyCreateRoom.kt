package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.game.serialization.UntilVersion
import moe.crx.roadblock.objects.account.*
import moe.crx.roadblock.objects.party.*
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class PartyCreateRoomRequest(
    var eventId: CalendarEventId,
    var customizablePrivateRaceSettings: CustomizablePrivateRaceSettings,
    var racerData: PartyRacerData?,
    @FromVersion("24.0.0")
    var userRole: UserRole = UserRole.Racer,
    @UntilVersion("24.0.0")
    var snsCredential: Credentials? = null,
    var regionLatencyMap: Map<String, List<LatencySample>>?,
    @FromVersion("24.0.0")
    var partyReadyState: PartyReadyState = PartyReadyState.NotReady,
) : RequestPacket()

@Serializable
data class PartyCreateRoomResponse(
    var requiredPlaybackDetailLevel: RequiredPlaybackDetailLevel = RequiredPlaybackDetailLevel.OnlyPlayer,
    var requiredPlaybackCondition: RequiredPlaybackCondition = RequiredPlaybackCondition.Never,
    var raceToken: RaceToken = 0u,
    @UntilVersion("24.0.0")
    var encryptedServerUserData: String = "",
    @UntilVersion("24.0.0")
    var encryptedServerRoomData: String = "",
    @UntilVersion("24.0.0")
    var clientUserData: String = "",
    @UntilVersion("24.0.0")
    var clientRoomData: String = "",
    @UntilVersion("24.0.0")
    var filter: String = "",
    @UntilVersion("24.0.0")
    var regionPreferences: List<RegionsPreferences>? = null,
    @FromVersion("24.0.0")
    var roomAccessCode: PartyRoomAccessCode = "",
    @FromVersion("24.0.0")
    var privateLobbyRoomData: PartyRoomData = PartyRoomData(),
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handlePartyCreateRoom(
    session: GameConnection,
    request: PartyCreateRoomRequest
) {
    session.sendResponse(PartyCreateRoomResponse())
}