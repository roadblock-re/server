package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.multiplayer.LatencySample
import moe.crx.roadblock.objects.RaceToken
import moe.crx.roadblock.objects.multiplayer.RegionsPreferences
import moe.crx.roadblock.objects.tournament.TournamentRoomData
import moe.crx.roadblock.objects.party.PartyRacerData
import moe.crx.roadblock.objects.party.PartyReadyState
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class TournamentJoinRoomRequest(
    var playstationMatchId: String,
    var racerData: PartyRacerData,
    var regionLatencyMap: Map<String, List<LatencySample>>?,
    var readyState: PartyReadyState,
) : RequestPacket()

@Serializable
data class TournamentJoinRoomResponse(
    var raceToken: RaceToken,
    var tournamentRoomData: TournamentRoomData,
    var regionPreferences: List<RegionsPreferences>? = null,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleTournamentJoinRoom(
    session: GameConnection,
    request: TournamentJoinRoomRequest
) {
    TODO()
}