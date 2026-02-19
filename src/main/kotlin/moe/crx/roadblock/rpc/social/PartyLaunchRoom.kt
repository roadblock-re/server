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
data class PartyLaunchRoomRequest(
    var teamRoomId: RoomId,
    var raceToken: RaceToken,
    var debugOptions: PrivateLobbyDebugOptions?,
) : RequestPacket()

@Serializable
data class PartyLaunchRoomResponse(
    var launchGameCommandResponse: LaunchGameCommandResponse = LaunchGameCommandResponse(),
    var gameplayServerLoginKey: ULong = 0u,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handlePartyLaunchRoom(
    session: GameConnection,
    request: PartyLaunchRoomRequest
) {
    session.sendResponse(PartyLaunchRoomResponse())
}