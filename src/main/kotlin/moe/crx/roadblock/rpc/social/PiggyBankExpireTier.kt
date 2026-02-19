package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.objects.account.PiggyBankTierId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class PiggyBankExpireTierRequest(
    var eventId: CalendarEventId,
    var piggyBankTierId: PiggyBankTierId,
) : RequestPacket()

@Serializable
class PiggyBankExpireTierResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handlePiggyBankExpireTier(
    session: GameConnection,
    request: PiggyBankExpireTierRequest
) {
    session.sendResponse(PiggyBankExpireTierResponse())
}