package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
class ClubRaceNotifyRoomJoinFailedRequest : RequestPacket()

@Serializable
class ClubRaceNotifyRoomJoinFailedResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClubRaceNotifyRoomJoinFailed(
    session: GameConnection,
    request: ClubRaceNotifyRoomJoinFailedRequest
) {
    session.sendResponse(ClubRaceNotifyRoomJoinFailedResponse())
}