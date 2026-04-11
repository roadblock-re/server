package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.Blob
import moe.crx.roadblock.game.serialization.ByteEnumUntil
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.objects.RaceToken
import moe.crx.roadblock.objects.multiplayer.RaceStats
import moe.crx.roadblock.objects.quarantine.QuarantineData
import moe.crx.roadblock.objects.transactions.CustomMultiplierType
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
    @FromVersion("24.0.0") @ByteEnumUntil("45.0.0") // TODO find exact version
    var customAdsMultiplier: CustomMultiplierType? = null,
    @FromVersion("24.0.0") @ByteEnumUntil("45.0.0") // TODO find exact version
    var defaultAdsMultiplier: CustomMultiplierType? = null,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleCareerFinishRace(
    session: GameConnection,
    request: CareerFinishRaceRequest
) {
    session.sendResponse(CareerFinishRaceResponse())
}