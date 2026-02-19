package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.AsphaltProductID
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.objects.account.UserCustomizableBundleReward
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class UserCustomizableBundleValidateProductPurchaseRequest(
    var eventId: CalendarEventId,
    var productId: AsphaltProductID,
    var userSelectedRewards: List<UserCustomizableBundleReward>,
) : RequestPacket()

@Serializable
class UserCustomizableBundleValidateProductPurchaseResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleUserCustomizableBundleValidateProductPurchase(
    session: GameConnection,
    request: UserCustomizableBundleValidateProductPurchaseRequest
) {
    session.sendResponse(UserCustomizableBundleValidateProductPurchaseResponse())
}