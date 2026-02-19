package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.RoomId
import moe.crx.roadblock.objects.party.CustomizablePrivateRaceSettings
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class PartyUpdateRoomDataRequest(
    var teamRoomId: RoomId,
    var customizablePrivateRaceSettings: CustomizablePrivateRaceSettings
) : RequestPacket()

@Serializable
class PartyUpdateRoomDataResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handlePartyUpdateRoomData(
    session: GameConnection,
    request: PartyUpdateRoomDataRequest
) {
    session.sendResponse(PartyUpdateRoomDataResponse())
}