package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class UpdateGamertagRequest(
    var gamertag: String,
) : RequestPacket()

@Serializable
class UpdateGamertagResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleUpdateGamertag(
    session: GameConnection,
    request: UpdateGamertagRequest
) {
    session.sendResponse(UpdateGamertagResponse())
}