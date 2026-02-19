package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.RaceToken
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ClubWarsAttackCancelRaceRequest(
    var raceToken: RaceToken,
    var raceTimeMicroseconds: UInt,
    var debugSuffix: String,
) : RequestPacket()

@Serializable
class ClubWarsAttackCancelRaceResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClubWarsAttackCancelRace(
    session: GameConnection,
    request: ClubWarsAttackCancelRaceRequest
) {
    session.sendResponse(ClubWarsAttackCancelRaceResponse())
}