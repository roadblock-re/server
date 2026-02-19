package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.objects.account.CarId
import moe.crx.roadblock.objects.customization.CarVisualConfiguration
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class SetPreferredCarVisualRequest(
    var carId: CarId,
    var visualConfiguration: CarVisualConfiguration,
    @FromVersion("47.1.0")
    var timeSpentInCustomizationMenu: ULong = 0u,
) : RequestPacket()

@Serializable
class SetPreferredCarVisualResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleSetPreferredCarVisual(
    session: GameConnection,
    request: SetPreferredCarVisualRequest
) {
    session.sendResponse(SetPreferredCarVisualResponse())
}