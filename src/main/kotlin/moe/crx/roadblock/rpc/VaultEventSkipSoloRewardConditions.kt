package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.Money
import moe.crx.roadblock.objects.VaultEventId
import moe.crx.roadblock.objects.VaultStageId
import moe.crx.roadblock.objects.inventory.CurrencyType
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class VaultEventSkipSoloRewardConditionsRequest(
    var eventId: VaultEventId,
    var stageId: VaultStageId,
    var rewardIdx: UByte,
    var currencyType: CurrencyType,
    var cost: Money,
) : RequestPacket()

@Serializable
class VaultEventSkipSoloRewardConditionsResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleVaultEventSkipSoloRewardConditions(
    session: GameConnection,
    request: VaultEventSkipSoloRewardConditionsRequest
) {
    session.sendResponse(VaultEventSkipSoloRewardConditionsResponse())
}