package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.GarageLevel
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GainGarageLevelCheatRequest(
    var amount: GarageLevel,
) : RequestPacket()

@Serializable
class GainGarageLevelCheatResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGainGarageLevelCheat(
    session: GameConnection,
    request: GainGarageLevelCheatRequest
) {
    session.sendResponse(GainGarageLevelCheatResponse())
}