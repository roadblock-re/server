package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.clubrace.ClubRaceRoom
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ClubRaceNotifyRoomJoinedRequest(
    var room: ClubRaceRoom,
) : RequestPacket()

@Serializable
class ClubRaceNotifyRoomJoinedResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClubRaceNotifyRoomJoined(
    session: GameConnection,
    request: ClubRaceNotifyRoomJoinedRequest
) {
    session.sendResponse(ClubRaceNotifyRoomJoinedResponse())
}