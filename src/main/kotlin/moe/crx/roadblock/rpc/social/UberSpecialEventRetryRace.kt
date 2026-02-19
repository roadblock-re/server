package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.UntilVersion
import moe.crx.roadblock.objects.account.RaceToken
import moe.crx.roadblock.objects.multiplayer.RaceStats
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class UberSpecialEventRetryRaceRequest(
    @UntilVersion("47.1.0")
    var raceToken: RaceToken = 0u,
    var raceStats: RaceStats,
) : RequestPacket()

@Serializable
data class UberSpecialEventRetryRaceResponse(
    var raceToken: RaceToken = 0u,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleUberSpecialEventRetryRace(
    session: GameConnection,
    request: UberSpecialEventRetryRaceRequest
) {
    session.sendResponse(UberSpecialEventRetryRaceResponse())
}