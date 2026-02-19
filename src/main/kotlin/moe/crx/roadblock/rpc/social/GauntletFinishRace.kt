package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.Blob
import moe.crx.roadblock.objects.account.RaceToken
import moe.crx.roadblock.objects.multiplayer.RaceStats
import moe.crx.roadblock.objects.quarantine.QuarantineData
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GauntletFinishRaceRequest(
    var raceId: RaceToken,
    var raceStats: RaceStats,
    var quarantineData: QuarantineData,
    var playback: Blob,
    var skipEvidences: Boolean,
) : RequestPacket()

@Serializable
class GauntletFinishRaceResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGauntletFinishRace(
    session: GameConnection,
    request: GauntletFinishRaceRequest
) {
    session.sendResponse(GauntletFinishRaceResponse())
}