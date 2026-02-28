package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.RaceToken
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ClubRaceStartRaceRequest(
    var raceToken: RaceToken,
) : RequestPacket()

@Serializable
data class ClubRaceStartRaceResponse(
    var gameplayServerLoginKey: ULong = 0u,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClubRaceStartRace(
    session: GameConnection,
    request: ClubRaceStartRaceRequest
) {
    session.sendResponse(ClubRaceStartRaceResponse())
}