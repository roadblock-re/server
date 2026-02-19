package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.RaceToken
import moe.crx.roadblock.objects.account.RoomId
import moe.crx.roadblock.objects.party.LaunchGameCommandResponse
import moe.crx.roadblock.objects.party.PrivateLobbyDebugOptions
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class TournamentLaunchRoomRequest(
    var teamRoomId: RoomId,
    var raceToken: RaceToken,
    var debugOptions: PrivateLobbyDebugOptions?,
) : RequestPacket()

@Serializable
data class TournamentLaunchRoomResponse(
    var launchGameCommandResponse: LaunchGameCommandResponse = LaunchGameCommandResponse(),
    var gameplayServerLoginKey: ULong = 0u,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleTournamentLaunchRoom(
    session: GameConnection,
    request: TournamentLaunchRoomRequest
) {
    session.sendResponse(TournamentLaunchRoomResponse())
}