package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.ByteEnum
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.objects.transactions.CustomMultiplierType
import moe.crx.roadblock.objects.RaceToken
import moe.crx.roadblock.objects.multiplayer.ConnectionStats
import moe.crx.roadblock.objects.multiplayer.DivergenceStats
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class MultiplayerSeriesFinishRaceRequest(
    var raceToken: RaceToken,
    var tryCount: UInt,
    var maxTries: UInt,
    @FromVersion("47.1.0")
    var connectionStats: ConnectionStats = ConnectionStats(),
    @FromVersion("47.1.0")
    var divergenceStats: DivergenceStats = DivergenceStats(),
) : RequestPacket()

@Serializable
data class MultiplayerSeriesFinishRaceResponse(
    @ByteEnum
    var customAdsMultiplier: CustomMultiplierType? = null,
    @ByteEnum
    var defaultAdsMultiplier: CustomMultiplierType? = null
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleMultiplayerSeriesFinishRace(
    session: GameConnection,
    request: MultiplayerSeriesFinishRaceRequest
) {
    session.sendResponse(MultiplayerSeriesFinishRaceResponse())
}