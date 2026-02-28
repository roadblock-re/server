package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.GarageLevel
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ClaimLevelUpGachaBoxesRequest(
    var garageLevel: GarageLevel,
    var boxesCount: UInt,
) : RequestPacket()

@Serializable
class ClaimLevelUpGachaBoxesResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClaimLevelUpGachaBoxes(
    session: GameConnection,
    request: ClaimLevelUpGachaBoxesRequest
) {
    session.sendResponse(ClaimLevelUpGachaBoxesResponse())
}