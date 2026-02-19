package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class SplitScreenStartRaceRequest(
    var playersCount: UInt,
) : RequestPacket()

@Serializable
class SplitScreenStartRaceResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleSplitScreenStartRace(
    session: GameConnection,
    request: SplitScreenStartRaceRequest
) {
    session.sendResponse(SplitScreenStartRaceResponse())
}