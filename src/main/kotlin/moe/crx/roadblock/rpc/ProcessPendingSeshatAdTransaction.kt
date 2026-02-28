package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.objects.RelayOfferTierId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ProcessPendingSeshatAdTransactionRequest(
    var carIdForRefill: CarId?,
    var specialCalendarEventId: CalendarEventId?,
    var relayOfferTierId: RelayOfferTierId?,
    var walletEventId: CalendarEventId?,
) : RequestPacket()

@Serializable
class ProcessPendingSeshatAdTransactionResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleProcessPendingSeshatAdTransaction(
    session: GameConnection,
    request: ProcessPendingSeshatAdTransactionRequest
) {
    session.sendResponse(ProcessPendingSeshatAdTransactionResponse())
}