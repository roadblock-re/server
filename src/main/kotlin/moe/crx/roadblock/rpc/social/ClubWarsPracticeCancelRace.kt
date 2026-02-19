package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.RaceToken
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ClubWarsPracticeCancelRaceRequest(
    var raceToken: RaceToken,
    var raceTimeMicroseconds: UInt,
) : RequestPacket()

@Serializable
class ClubWarsPracticeCancelRaceResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClubWarsPracticeCancelRace(
    session: GameConnection,
    request: ClubWarsPracticeCancelRaceRequest
) {
    session.sendResponse(ClubWarsPracticeCancelRaceResponse())
}