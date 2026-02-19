package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.UntilVersion
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.objects.account.RelayOfferTierId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class BuyRelayOfferTierRequest(
    var eventId: CalendarEventId,
    var tierId: RelayOfferTierId,
    @UntilVersion("47.1.0")
    var walletEventId: CalendarEventId? = null,
) : RequestPacket()

@Serializable
class BuyRelayOfferTierResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleBuyRelayOfferTier(
    session: GameConnection,
    request: BuyRelayOfferTierRequest
) {
    session.sendResponse(BuyRelayOfferTierResponse())
}