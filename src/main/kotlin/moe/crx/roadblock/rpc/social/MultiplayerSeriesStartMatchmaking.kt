package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.*
import moe.crx.roadblock.objects.multiplayer.MultiplayerSeriesMatchmakingDebugOptions
import moe.crx.roadblock.objects.settings.ControlSchemeType
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.ResponsePacket

@Serializable
data class MultiplayerSeriesStartMatchmakingRequest(
    var debugOptions: MultiplayerSeriesMatchmakingDebugOptions,
    var seriesId: MultiplayerSeriesId,
    var eventId: CalendarEventId,
    var carId: CarId,
    var controlSchemeType: ControlSchemeType,
    var regionLatencyMap: Map<String, List<LatencySample>>?,
    var connectivityType: String,
) : RequestPacket()

@Serializable
data class MultiplayerSeriesStartMatchmakingResponse(
    var raceToken: RaceToken = 0u,
    var finishRaceRetries: List<UInt> = listOf(),
    var updates: StatusUpdatesQueueWithRootReactions = StatusUpdatesQueueWithRootReactions(),
) : ResponsePacket()

suspend fun handleMultiplayerSeriesStartMatchmaking(
    session: GameConnection,
    request: MultiplayerSeriesStartMatchmakingRequest
) {
    session.sendResponse(MultiplayerSeriesStartMatchmakingResponse())
}