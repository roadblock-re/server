package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CarId
import moe.crx.roadblock.objects.account.EventTrackDefId
import moe.crx.roadblock.objects.account.PlayerId
import moe.crx.roadblock.objects.inventory.CarClass
import moe.crx.roadblock.objects.multiplayer.RaceStats
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class SplitScreenEndRaceRequest(
    var slipstream: Boolean,
    var numLaps: Int,
    var numRacers: Int,
    var raceCarClass: CarClass,
    var trackDefId: EventTrackDefId,
    var stats: RaceStats?,
    var playerCarsId: Map<PlayerId, CarId?>,
) : RequestPacket()

@Serializable
class SplitScreenEndRaceResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleSplitScreenEndRace(
    session: GameConnection,
    request: SplitScreenEndRaceRequest
) {
    session.sendResponse(SplitScreenEndRaceResponse())
}