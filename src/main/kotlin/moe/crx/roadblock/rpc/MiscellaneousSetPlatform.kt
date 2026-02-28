package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.social.PlatformType
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class MiscellaneousSetPlatformRequest(
    var currentPlatform: PlatformType,
) : RequestPacket()

@Serializable
class MiscellaneousSetPlatformResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleMiscellaneousSetPlatform(
    session: GameConnection,
    request: MiscellaneousSetPlatformRequest
) {
    session.sendResponse(MiscellaneousSetPlatformResponse())
}