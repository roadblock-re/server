package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.AdRequestId
import moe.crx.roadblock.objects.CampaignId
import moe.crx.roadblock.objects.CreativeId
import moe.crx.roadblock.objects.miscellaneous.AdProvider
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class SaveObtainedAdsRewardDataIntoServerStateRequest(
    var itemId: String,
    var pointcutName: String,
    var adRequestId: AdRequestId,
    var campaignId: CampaignId,
    var creativeId: CreativeId,
    var adProvider: AdProvider?,
) : RequestPacket()

@Serializable
class SaveObtainedAdsRewardDataIntoServerStateResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleSaveObtainedAdsRewardDataIntoServerState(
    session: GameConnection,
    request: SaveObtainedAdsRewardDataIntoServerStateRequest
) {
    session.sendResponse(SaveObtainedAdsRewardDataIntoServerStateResponse())
}