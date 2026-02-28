package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.RoomId
import moe.crx.roadblock.objects.party.PartyRacerData
import moe.crx.roadblock.objects.party.PartyReadyState
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class TournamentUpdateUserDataRequest(
    var teamRoomId: RoomId,
    var tournamentReadyState: PartyReadyState,
    var racerData: PartyRacerData,
) : RequestPacket()

@Serializable
class TournamentUpdateUserDataResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleTournamentUpdateUserData(
    session: GameConnection,
    request: TournamentUpdateUserDataRequest
) {
    session.sendResponse(TournamentUpdateUserDataResponse())
}