package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.Blob
import moe.crx.roadblock.game.serialization.ByteEnum
import moe.crx.roadblock.objects.account.CustomMultiplierType
import moe.crx.roadblock.objects.account.RaceToken
import moe.crx.roadblock.objects.multiplayer.RaceStats
import moe.crx.roadblock.objects.quarantine.QuarantineData
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class UberSpecialEventCommitResultsRaceRequest(
    var raceToken: RaceToken,
    var stats: RaceStats,
    var quarantineData: QuarantineData,
    var playback: Blob,
) : RequestPacket()

@Serializable
data class UberSpecialEventCommitResultsRaceResponse(
    @ByteEnum
    var customAdsMultiplier: CustomMultiplierType? = null,
    @ByteEnum
    var defaultAdsMultiplier: CustomMultiplierType? = null,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleUberSpecialEventCommitResultsRace(
    session: GameConnection,
    request: UberSpecialEventCommitResultsRaceRequest
) {
    session.sendResponse(UberSpecialEventCommitResultsRaceResponse())
}