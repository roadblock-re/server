package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GainCareerFlagsCheatRequest(
    var someUnknownValue: UInt,
) : RequestPacket()

@Serializable
class GainCareerFlagsCheatResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGainCareerFlagsCheat(
    session: GameConnection,
    request: GainCareerFlagsCheatRequest
) {
    session.sendResponse(GainCareerFlagsCheatResponse())
}