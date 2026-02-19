package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.PriceWithCurrency
import moe.crx.roadblock.objects.account.VaultEventId
import moe.crx.roadblock.objects.account.VaultTicket
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class VaultExtendEventRequest(
    var eventId: VaultEventId,
    var price: PriceWithCurrency,
    var extraMinutes: UInt,
    var extraTicket: VaultTicket?,
) : RequestPacket()

@Serializable
class VaultExtendEventResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleVaultExtendEvent(
    session: GameConnection,
    request: VaultExtendEventRequest
) {
    session.sendResponse(VaultExtendEventResponse())
}