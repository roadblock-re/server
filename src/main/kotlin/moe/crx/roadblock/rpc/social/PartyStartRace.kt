package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.objects.account.RaceToken
import moe.crx.roadblock.objects.account.RoomId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class PartyStartRaceRequest(
    var raceToken: RaceToken,
    @FromVersion("24.0.0")
    var teamRoomId: RoomId = "",
    var roomId: RoomId,
) : RequestPacket()

@Serializable
data class PartyStartRaceResponse(
    var gameplayServerLoginKey: ULong = 0u
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handlePartyStartRace(
    session: GameConnection,
    request: PartyStartRaceRequest
) {
    session.sendResponse(PartyStartRaceResponse())
}