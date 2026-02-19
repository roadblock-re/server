package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CarId
import moe.crx.roadblock.objects.account.ClubWarsMarketProductId
import moe.crx.roadblock.objects.account.Money
import moe.crx.roadblock.objects.inventory.CurrencyType
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ClubWarsMarketBuyRequest(
    var productId: ClubWarsMarketProductId,
    var currency: CurrencyType,
    var cost: Money,
    var carId: CarId,
) : RequestPacket()

@Serializable
class ClubWarsMarketBuyResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClubWarsMarketBuy(
    session: GameConnection,
    request: ClubWarsMarketBuyRequest
) {
    session.sendResponse(ClubWarsMarketBuyResponse())
}