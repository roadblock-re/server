package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.RaceToken
import moe.crx.roadblock.objects.tle.TLEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class TLEventCancelRaceRequest(
    var tlEventId: TLEventId,
    var raceToken: RaceToken,
    var raceTimeMicroseconds: UInt,
) : RequestPacket()

@Serializable
class TLEventCancelRaceResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleTLEventCancelRace(
    session: GameConnection,
    request: TLEventCancelRaceRequest
) {
    session.sendResponse(TLEventCancelRaceResponse())
}