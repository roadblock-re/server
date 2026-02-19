package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.RaceToken
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class PartyCancelRaceRequest(
    var raceToken: RaceToken,
    var raceTimeMicroseconds: UInt,
    var worstRTTMicroseconds: UInt,
    var averageRTTMicroseconds: UInt,
    var isRTTInformationReliable: Boolean,
    var numberOfRacers: UInt,
    var gridSpotIndex: UInt,
) : RequestPacket()

@Serializable
class PartyCancelRaceResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handlePartyCancelRace(
    session: GameConnection,
    request: PartyCancelRaceRequest
) {
    session.sendResponse(PartyCancelRaceResponse())
}