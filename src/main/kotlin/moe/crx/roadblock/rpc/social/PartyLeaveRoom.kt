package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.RoomId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class PartyLeaveRoomRequest(
    var roomId: RoomId,
) : RequestPacket()

@Serializable
class PartyLeaveRoomResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handlePartyLeaveRoom(
    session: GameConnection,
    request: PartyLeaveRoomRequest
) {
    session.sendResponse(PartyLeaveRoomResponse())
}