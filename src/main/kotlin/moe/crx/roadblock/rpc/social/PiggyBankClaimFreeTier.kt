package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.objects.account.PiggyBankEventId
import moe.crx.roadblock.objects.account.PiggyBankTierId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class PiggyBankClaimFreeTierRequest(
    var eventId: CalendarEventId,
    var piggyBankEventId: PiggyBankEventId,
    var piggyBankTierId: PiggyBankTierId,
) : RequestPacket()

@Serializable
class PiggyBankClaimFreeTierResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handlePiggyBankClaimFreeTier(
    session: GameConnection,
    request: PiggyBankClaimFreeTierRequest
) {
    session.sendResponse(PiggyBankClaimFreeTierResponse())
}