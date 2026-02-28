package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.StatusUpdatesQueueWithRootReactions
import moe.crx.roadblock.objects.miscellaneous.TransferCode
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.ResponsePacket

@Serializable
class CreateTransferCodeRequest : RequestPacket()

@Serializable
data class CreateTransferCodeResponse(
    var transferCode: TransferCode = TransferCode(),
    var updatesQueue: StatusUpdatesQueueWithRootReactions = StatusUpdatesQueueWithRootReactions(),
) : ResponsePacket()

suspend fun handleCreateTransferCode(
    session: GameConnection,
    request: CreateTransferCodeRequest
) {
    session.sendResponse(CreateTransferCodeResponse())
}