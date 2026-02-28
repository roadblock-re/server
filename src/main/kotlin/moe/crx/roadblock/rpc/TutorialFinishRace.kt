package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.objects.EventTrackDefId
import moe.crx.roadblock.objects.multiplayer.RaceStats
import moe.crx.roadblock.objects.playerstats.TutorialEventId
import moe.crx.roadblock.objects.playerstats.TutorialStartReason
import moe.crx.roadblock.objects.settings.ControlSchemeType
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class TutorialFinishRaceRequest(
    var eventId: TutorialEventId,
    var carId: CarId,
    var raceStats: RaceStats?,
    var raceTimeMicroseconds: UInt,
    var startReason: TutorialStartReason,
    var controlType: ControlSchemeType,
    @FromVersion("24.0.0")
    var isAutoAccelerationEnabled: Boolean = false, // TODO I'm not sure about it.
    @FromVersion("24.0.0")
    var trackDefId: EventTrackDefId = 0u,
) : RequestPacket()

@Serializable
class TutorialFinishRaceResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleTutorialFinishRace(
    session: GameConnection,
    request: TutorialFinishRaceRequest
) {
    session.sendResponse(TutorialFinishRaceResponse())
}