package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.ClubRaceRoomId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ClubRaceNotifyRoomLeftRequest(
    var roomId: ClubRaceRoomId,
) : RequestPacket()

@Serializable
class ClubRaceNotifyRoomLeftResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClubRaceNotifyRoomLeft(
    session: GameConnection,
    request: ClubRaceNotifyRoomLeftRequest
) {
    session.sendResponse(ClubRaceNotifyRoomLeftResponse())
}