package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.RaceToken
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ClubRaceCancelRaceRequest(
    var raceToken: RaceToken,
    var raceTimeMicroseconds: UInt,
    var worstRTTMicroseconds: UInt,
    var averageRTTMicroseconds: UInt,
    var isRTTInformationReliable: Boolean,
    var numberOfRacers: UInt,
    var gridSpotIndex: UInt,
) : RequestPacket()

@Serializable
class ClubRaceCancelRaceResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClubRaceCancelRace(
    session: GameConnection,
    request: ClubRaceCancelRaceRequest
) {
    session.sendResponse(ClubRaceCancelRaceResponse())
}