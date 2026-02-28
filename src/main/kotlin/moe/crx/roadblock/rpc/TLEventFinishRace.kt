package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.Blob
import moe.crx.roadblock.game.serialization.ByteEnum
import moe.crx.roadblock.objects.transactions.CustomMultiplierType
import moe.crx.roadblock.objects.RaceToken
import moe.crx.roadblock.objects.multiplayer.RaceStats
import moe.crx.roadblock.objects.quarantine.QuarantineData
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class TLEventFinishRaceRequest(
    var raceId: RaceToken,
    var raceStats: RaceStats,
    var quarantineData: QuarantineData,
    var playback: Blob,
) : RequestPacket()

@Serializable
data class TLEventFinishRaceResponse(
    @ByteEnum
    var customAdsMultiplier: CustomMultiplierType? = null,
    @ByteEnum
    var defaultAdsMultiplier: CustomMultiplierType? = null,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleTLEventFinishRace(
    session: GameConnection,
    request: TLEventFinishRaceRequest
) {
    session.sendResponse(TLEventFinishRaceResponse())
}