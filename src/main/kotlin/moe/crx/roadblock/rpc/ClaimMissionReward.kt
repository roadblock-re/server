package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.playerstats.MissionType
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ClaimMissionRewardRequest(
    var missionType: MissionType,
) : RequestPacket()

@Serializable
class ClaimMissionRewardResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClaimMissionReward(
    session: GameConnection,
    request: ClaimMissionRewardRequest
) {
    session.sendResponse(ClaimMissionRewardResponse())
}