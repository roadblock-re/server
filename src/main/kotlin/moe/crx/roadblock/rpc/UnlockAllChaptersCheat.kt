package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
class UnlockAllChaptersCheatRequest : RequestPacket()

@Serializable
class UnlockAllChaptersCheatResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleUnlockAllChaptersCheat(
    session: GameConnection,
    request: UnlockAllChaptersCheatRequest
) {
    session.sendResponse(UnlockAllChaptersCheatResponse())
}