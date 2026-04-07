package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.social.PlatformType
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse
import moe.crx.roadblock.updates.MiscellaneousCurrentPlatformChanged

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
    val reaction = MiscellaneousCurrentPlatformChanged(
        currentPlatform = request.currentPlatform
    )

    session.gameState.miscellaneous.platform = request.currentPlatform
    session.gameState.miscellaneous.legacyPlatform = request.currentPlatform

    session.sendResponse(MiscellaneousSetPlatformResponse().flatten(reaction))
}