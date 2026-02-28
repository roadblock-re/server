package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.ResponsePacket

@Serializable
class NotifyShutdownRequest : RequestPacket()

@Serializable
class NotifyShutdownResponse : ResponsePacket()

suspend fun handleNotifyShutdown(
    session: GameConnection,
    request: NotifyShutdownRequest
) {
    session.sendResponse(NotifyShutdownResponse())
}