package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.RaceToken
import moe.crx.roadblock.objects.RoomId
import moe.crx.roadblock.objects.multiplayer.LatencySample
import moe.crx.roadblock.objects.multiplayer.RegionsPreferences
import moe.crx.roadblock.objects.party.PartyRacerData
import moe.crx.roadblock.objects.party.PartyReadyState
import moe.crx.roadblock.objects.party.PartyRoomData
import moe.crx.roadblock.objects.party.UserRole
import moe.crx.roadblock.objects.quarantine.RequiredPlaybackCondition
import moe.crx.roadblock.objects.quarantine.RequiredPlaybackDetailLevel
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class PartyJoinByPartyIdRequest(
    var roomId: RoomId,
    var userRole: UserRole,
    var racerData: PartyRacerData,
    var regionLatencyMap: Map<String, List<LatencySample>>?,
    var partyReadyState: PartyReadyState,
) : RequestPacket()

@Serializable
data class PartyJoinByPartyIdResponse(
    var requiredPlaybackDetailLevel: RequiredPlaybackDetailLevel = RequiredPlaybackDetailLevel.OnlyPlayer,
    var requiredPlaybackCondition: RequiredPlaybackCondition = RequiredPlaybackCondition.Never,
    var raceToken: RaceToken = 0u,
    var privateLobbyRoomData: PartyRoomData = PartyRoomData(),
    var regionPreferences: List<RegionsPreferences>? = null,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handlePartyJoinByPartyId(
    session: GameConnection,
    request: PartyJoinByPartyIdRequest
) {
    session.sendResponse(PartyJoinByPartyIdResponse())
}