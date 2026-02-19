package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.objects.account.*
import moe.crx.roadblock.objects.multiplayer.RaceCancelReason
import moe.crx.roadblock.objects.multiplayer.RaceStats
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class MultiplayerSeriesCancelRaceRequest(
    var seriesId: MultiplayerSeriesId,
    var eventId: CalendarEventId,
    var raceToken: RaceToken,
    var raceTimeMicroseconds: Int,
    @FromVersion("24.0.0")
    var cancelReason: RaceCancelReason = RaceCancelReason.QuitFromPauseMenu,
    @FromVersion("24.0.0")
    var raceStats: RaceStats = RaceStats(),
    @FromVersion("47.1.0")
    var eloByFinishPosition: List<PlayerElo> = listOf(), // TODO I'm not sure about this.
    @FromVersion("47.1.0")
    var raceConfigId: MultiplayerRaceConfigId = 0u,
) : RequestPacket()

@Serializable
class MultiplayerSeriesCancelRaceResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleMultiplayerSeriesCancelRace(
    session: GameConnection,
    request: MultiplayerSeriesCancelRaceRequest
) {
    session.sendResponse(MultiplayerSeriesCancelRaceResponse())
}