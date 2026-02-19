package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.objects.account.LatencySample
import moe.crx.roadblock.objects.account.RaceToken
import moe.crx.roadblock.objects.account.TournamentRoomData
import moe.crx.roadblock.objects.party.CustomizablePrivateRaceSettings
import moe.crx.roadblock.objects.party.PartyRacerData
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class TournamentCreateRoomRequest(
    var eventId: CalendarEventId,
    var customizableTournamentRaceSettings: CustomizablePrivateRaceSettings,
    var racerData: PartyRacerData,
    var regionLatencyMap: Map<String, List<LatencySample>>?,
    var readyState: UByte,
    var tournamentMatchId: String,
) : RequestPacket()

@Serializable
data class TournamentCreateRoomResponse(
    var raceToken: RaceToken,
    var tournamentRoomData: TournamentRoomData,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleTournamentCreateRoom(
    session: GameConnection,
    request: TournamentCreateRoomRequest
) {
    TODO()
}