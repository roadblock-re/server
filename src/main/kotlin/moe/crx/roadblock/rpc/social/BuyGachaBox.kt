package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.objects.account.CollectorStage
import moe.crx.roadblock.objects.gacha.GachaType
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class BuyGachaBoxRequest(
    var gachaType: GachaType,
    var boxesToOpenCount: UInt,
    var compactRewards: Boolean,
    var doCriticalRoll: Boolean,
    var walletEventId: CalendarEventId?,
    @FromVersion("24.0.0")
    var premiumGachaCollectorStage: CollectorStage = 0u,
) : RequestPacket()

@Serializable
class BuyGachaBoxResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleBuyGachaBox(
    session: GameConnection,
    request: BuyGachaBoxRequest
) {
    session.sendResponse(BuyGachaBoxResponse())
}