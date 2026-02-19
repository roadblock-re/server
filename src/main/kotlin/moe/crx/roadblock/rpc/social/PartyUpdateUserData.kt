package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.RoomId
import moe.crx.roadblock.objects.party.PartyRacerData
import moe.crx.roadblock.objects.party.PartyReadyState
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class PartyUpdateUserDataRequest(
    var teamRoomId: RoomId,
    var partyReadyState: PartyReadyState,
    var racerData: PartyRacerData,
) : RequestPacket()

@Serializable
class PartyUpdateUserDataResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handlePartyUpdateUserData(
    session: GameConnection,
    request: PartyUpdateUserDataRequest
) {
    session.sendResponse(PartyUpdateUserDataResponse())
}