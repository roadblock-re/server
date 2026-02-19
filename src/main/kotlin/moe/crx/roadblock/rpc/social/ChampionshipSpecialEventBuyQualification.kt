package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.objects.account.Money
import moe.crx.roadblock.objects.inventory.CurrencyType
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ChampionshipSpecialEventBuyQualificationRequest(
    var eventId: CalendarEventId,
    var currencyType: CurrencyType,
    var cost: Money,
    var debugSuffix: String,
) : RequestPacket()

@Serializable
class ChampionshipSpecialEventBuyQualificationResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleChampionshipSpecialEventBuyQualification(
    session: GameConnection,
    request: ChampionshipSpecialEventBuyQualificationRequest
) {
    session.sendResponse(ChampionshipSpecialEventBuyQualificationResponse())
}