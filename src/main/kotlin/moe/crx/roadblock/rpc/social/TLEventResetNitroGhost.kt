package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.Money
import moe.crx.roadblock.objects.inventory.CurrencyType
import moe.crx.roadblock.objects.tle.TLEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class TLEventResetNitroGhostRequest(
    var tlEventId: TLEventId,
    var currencyType: CurrencyType,
    var cost: Money,
) : RequestPacket()

@Serializable
class TLEventResetNitroGhostResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleTLEventResetNitroGhost(
    session: GameConnection,
    request: TLEventResetNitroGhostRequest
) {
    session.sendResponse(TLEventResetNitroGhostResponse())
}