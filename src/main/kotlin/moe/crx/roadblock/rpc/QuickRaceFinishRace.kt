package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.OfflineQuickRaceEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class QuickRaceFinishRaceRequest(
    var playedEvent: OfflineQuickRaceEventId,
    var unlockedEvents: List<OfflineQuickRaceEventId>,
) : RequestPacket()

@Serializable
class QuickRaceFinishRaceResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleQuickRaceFinishRace(
    session: GameConnection,
    request: QuickRaceFinishRaceRequest
) {
    session.sendResponse(QuickRaceFinishRaceResponse())
}