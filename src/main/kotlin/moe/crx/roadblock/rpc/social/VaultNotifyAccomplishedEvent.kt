package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.VaultEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class VaultNotifyAccomplishedEventRequest(
    var eventId: VaultEventId,
) : RequestPacket()

@Serializable
class VaultNotifyAccomplishedEventResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleVaultNotifyAccomplishedEvent(
    session: GameConnection,
    request: VaultNotifyAccomplishedEventRequest
) {
    session.sendResponse(VaultNotifyAccomplishedEventResponse())
}