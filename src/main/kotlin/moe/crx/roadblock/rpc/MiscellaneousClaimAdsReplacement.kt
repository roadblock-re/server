package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.miscellaneous.AdsExtraInformation
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class MiscellaneousClaimAdsReplacementRequest(
    var typeProperty: UInt,
    var extraInformation: AdsExtraInformation,
) : RequestPacket()

@Serializable
class MiscellaneousClaimAdsReplacementResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleMiscellaneousClaimAdsReplacement(
    session: GameConnection,
    request: MiscellaneousClaimAdsReplacementRequest
) {
    session.sendResponse(MiscellaneousClaimAdsReplacementResponse())
}