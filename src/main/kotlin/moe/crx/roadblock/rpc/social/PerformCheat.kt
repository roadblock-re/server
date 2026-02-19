package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CheatToPerform
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class PerformCheatRequest(
    var cheatToPerform: CheatToPerform,
) : RequestPacket()

@Serializable
class PerformCheatResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handlePerformCheat(
    session: GameConnection,
    request: PerformCheatRequest
) {
    session.sendResponse(PerformCheatResponse())
}