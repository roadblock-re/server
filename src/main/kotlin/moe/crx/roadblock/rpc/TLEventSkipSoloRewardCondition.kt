package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.Money
import moe.crx.roadblock.objects.inventory.CurrencyType
import moe.crx.roadblock.objects.tle.TLEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class TLEventSkipSoloRewardConditionRequest(
    var tlEventId: TLEventId,
    var rewardIdx: UByte,
    var currencyType: CurrencyType,
    var cost: Money,
) : RequestPacket()

@Serializable
class TLEventSkipSoloRewardConditionResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleTLEventSkipSoloRewardCondition(
    session: GameConnection,
    request: TLEventSkipSoloRewardConditionRequest
) {
    session.sendResponse(TLEventSkipSoloRewardConditionResponse())
}