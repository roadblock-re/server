package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.inventory.TrashableItem
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class TrashItemRequest(
    var item: TrashableItem,
    var amount: UInt,
) : RequestPacket()

@Serializable
class TrashItemResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleTrashItem(
    session: GameConnection,
    request: TrashItemRequest
) {
    session.sendResponse(TrashItemResponse())
}