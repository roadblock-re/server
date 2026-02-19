package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
class OverclockResetOverclockChipsCheatRequest : RequestPacket()

@Serializable
class OverclockResetOverclockChipsCheatResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleOverclockResetOverclockChipsCheat(
    session: GameConnection,
    request: OverclockResetOverclockChipsCheatRequest
) {
    session.sendResponse(OverclockResetOverclockChipsCheatResponse())
}