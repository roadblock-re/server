package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.Blueprints
import moe.crx.roadblock.objects.account.CarUpgradeTier
import moe.crx.roadblock.objects.inventory.CarClass
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GainWildcardBlueprintsCheatRequest(
    var carClass: CarClass,
    var tier: CarUpgradeTier,
    var amount: Blueprints,
) : RequestPacket()

@Serializable
class GainWildcardBlueprintsCheatResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGainWildcardBlueprintsCheat(
    session: GameConnection,
    request: GainWildcardBlueprintsCheatRequest
) {
    session.sendResponse(GainWildcardBlueprintsCheatResponse())
}