package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.ResponsePacket

@Serializable
class ResetUserStateRequest : RequestPacket()

@Serializable
class ResetUserStateResponse : ResponsePacket()

suspend fun handleResetUserState(
    session: GameConnection,
    request: ResetUserStateRequest
) {
    session.sendResponse(ResetUserStateResponse())
}