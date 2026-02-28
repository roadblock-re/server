package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.RaceToken
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class VaultEventCancelRaceRequest(
    var raceToken: RaceToken,
) : RequestPacket()

@Serializable
class VaultEventCancelRaceResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleVaultEventCancelRace(
    session: GameConnection,
    request: VaultEventCancelRaceRequest
) {
    session.sendResponse(VaultEventCancelRaceResponse())
}