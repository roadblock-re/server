package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.Blob
import moe.crx.roadblock.game.serialization.ByteEnum
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.objects.account.CustomMultiplierType
import moe.crx.roadblock.objects.account.RaceToken
import moe.crx.roadblock.objects.multiplayer.RaceStats
import moe.crx.roadblock.objects.quarantine.QuarantineData
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class CareerFinishRaceRequest(
    var raceId: RaceToken,
    var raceStats: RaceStats,
    var quarantineData: QuarantineData,
    var playback: Blob,
) : RequestPacket()

@Serializable
data class CareerFinishRaceResponse(
    @FromVersion("45.0.0") @ByteEnum
    var customAdsMultiplier: CustomMultiplierType? = null,
    @FromVersion("45.0.0") @ByteEnum
    var defaultAdsMultiplier: CustomMultiplierType? = null,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleCareerFinishRace(
    session: GameConnection,
    request: CareerFinishRaceRequest
) {
    session.sendResponse(CareerFinishRaceResponse())
}