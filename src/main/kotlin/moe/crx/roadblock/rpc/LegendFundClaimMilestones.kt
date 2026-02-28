package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.GarageLevel
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class LegendFundClaimMilestonesRequest(
    var level: GarageLevel = 0u,
) : RequestPacket()

@Serializable
class LegendFundClaimMilestonesResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleLegendFundClaimMilestones(
    session: GameConnection,
    request: LegendFundClaimMilestonesRequest
) {
    session.sendResponse(LegendFundClaimMilestonesResponse())
}