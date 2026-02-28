package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.RaceToken
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class TournamentCancelRaceRequest(
    var raceToken: RaceToken,
    var raceTimeMicroseconds: UInt,
    var worstRTTMicroseconds: UInt,
    var averageRTTMicroseconds: UInt,
    var isRTTInformationReliable: Boolean,
    var numberOfRacers: UInt,
    var gridSpotIndex: UInt,
) : RequestPacket()

@Serializable
class TournamentCancelRaceResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleTournamentCancelRace(
    session: GameConnection,
    request: TournamentCancelRaceRequest
) {
    session.sendResponse(TournamentCancelRaceResponse())
}