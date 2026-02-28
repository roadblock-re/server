package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.Money
import moe.crx.roadblock.objects.UberTierId
import moe.crx.roadblock.objects.inventory.CurrencyType
import moe.crx.roadblock.objects.uber.UberPoolMissionId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class UberSpecialEventSkipMissionRequest(
    var eventId: CalendarEventId,
    var tierId: UberTierId,
    var poolMissionId: UberPoolMissionId,
    var currencyType: CurrencyType,
    var cost: Money,
) : RequestPacket()

@Serializable
class UberSpecialEventSkipMissionResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleUberSpecialEventSkipMission(
    session: GameConnection,
    request: UberSpecialEventSkipMissionRequest
) {
    session.sendResponse(UberSpecialEventSkipMissionResponse())
}