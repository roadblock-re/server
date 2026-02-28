package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.RaceToken
import moe.crx.roadblock.objects.RoomId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class TournamentStartRaceRequest(
    var raceToken: RaceToken,
    var teamRoomId: RoomId,
    var raceRoomId: RoomId,
) : RequestPacket()

@Serializable
data class TournamentStartRaceResponse(
    var gameplayServerLoginKey: ULong = 0u,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleTournamentStartRace(
    session: GameConnection,
    request: TournamentStartRaceRequest
) {
    session.sendResponse(TournamentStartRaceResponse())
}