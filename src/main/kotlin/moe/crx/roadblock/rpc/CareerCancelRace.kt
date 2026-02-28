package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.RaceToken
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class CareerCancelRaceRequest(
    var raceId: RaceToken,
    var raceTimeMicroseconds: UInt,
) : RequestPacket()

@Serializable
class CareerCancelRaceResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleCareerCancelRace(
    session: GameConnection,
    request: CareerCancelRaceRequest
) {
    session.sendResponse(CareerCancelRaceResponse())
}