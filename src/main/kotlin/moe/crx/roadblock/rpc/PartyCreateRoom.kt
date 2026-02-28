package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.game.serialization.UntilVersion
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.PartyRoomAccessCode
import moe.crx.roadblock.objects.RaceToken
import moe.crx.roadblock.objects.multiplayer.LatencySample
import moe.crx.roadblock.objects.multiplayer.RegionsPreferences
import moe.crx.roadblock.objects.party.*
import moe.crx.roadblock.objects.quarantine.RequiredPlaybackCondition
import moe.crx.roadblock.objects.quarantine.RequiredPlaybackDetailLevel
import moe.crx.roadblock.objects.social.Credentials
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