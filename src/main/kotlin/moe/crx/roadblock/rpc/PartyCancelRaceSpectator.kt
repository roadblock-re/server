package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.RaceToken
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class PartyCancelRaceSpectatorRequest(
    var raceToken: RaceToken,
) : RequestPacket()

@Serializable
class PartyCancelRaceSpectatorResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handlePartyCancelRaceSpectator(
    session: GameConnection,
    request: PartyCancelRaceSpectatorRequest
) {
    session.sendResponse(PartyCancelRaceSpectatorResponse())
}