package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.Money
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class PiggyBankAddMoneyToBankCheatRequest(
    var moneyToAdd: Money,
) : RequestPacket()

@Serializable
class PiggyBankAddMoneyToBankCheatResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handlePiggyBankAddMoneyToBankCheat(
    session: GameConnection,
    request: PiggyBankAddMoneyToBankCheatRequest
) {
    session.sendResponse(PiggyBankAddMoneyToBankCheatResponse())
}