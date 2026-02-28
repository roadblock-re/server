package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.ChampionshipRoundId
import moe.crx.roadblock.objects.Money
import moe.crx.roadblock.objects.championship.ChampionshipStageType
import moe.crx.roadblock.objects.inventory.CurrencyType
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ChampionshipSpecialEventSkipRewardRequest(
    var eventId: CalendarEventId,
    var stageType: ChampionshipStageType,
    var roundId: ChampionshipRoundId,
    var rewardIdx: UByte,
    var currencyType: CurrencyType,
    var cost: Money,
) : RequestPacket()

@Serializable
class ChampionshipSpecialEventSkipRewardResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleChampionshipSpecialEventSkipReward(
    session: GameConnection,
    request: ChampionshipSpecialEventSkipRewardRequest
) {
    session.sendResponse(ChampionshipSpecialEventSkipRewardResponse())
}