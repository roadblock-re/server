package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.Money
import moe.crx.roadblock.objects.inventory.CurrencyType
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GainCurrencyCheatRequest(
    var currencyType: CurrencyType,
    var quantity: Money,
) : RequestPacket()

@Serializable
class GainCurrencyCheatResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGainCurrencyCheat(
    session: GameConnection,
    request: GainCurrencyCheatRequest
) {
    session.sendResponse(GainCurrencyCheatResponse())
}