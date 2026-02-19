package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CrossplayPlatformFilter
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class MiscellaneousSetCrossplayPlatformFilterRequest(
    var crossplayPlatformFilter: CrossplayPlatformFilter,
) : RequestPacket()

@Serializable
class MiscellaneousSetCrossplayPlatformFilterResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleMiscellaneousSetCrossplayPlatformFilter(
    session: GameConnection,
    request: MiscellaneousSetCrossplayPlatformFilterRequest
) {
    session.sendResponse(MiscellaneousSetCrossplayPlatformFilterResponse())
}