package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.GarageValue
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GainGarageValueCheatRequest(
    var amount: GarageValue,
) : RequestPacket()

@Serializable
class GainGarageValueCheatResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGainGarageValueCheat(
    session: GameConnection,
    request: GainGarageValueCheatRequest
) {
    session.sendResponse(GainGarageValueCheatResponse())
}