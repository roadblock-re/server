package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.Blob
import moe.crx.roadblock.game.serialization.ByteEnumUntil
import moe.crx.roadblock.objects.RaceToken
import moe.crx.roadblock.objects.multiplayer.RaceStats
import moe.crx.roadblock.objects.quarantine.QuarantineData
import moe.crx.roadblock.objects.transactions.CustomMultiplierType
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ClubWarsPracticeFinishRaceRequest(
    var raceToken: RaceToken,
    var stats: RaceStats,
    var quarantineData: QuarantineData,
    var playback: Blob,
    var debugSuffix: String,
) : RequestPacket()

@Serializable
data class ClubWarsPracticeFinishRaceResponse(
    @ByteEnumUntil("45.0.0") // TODO find exact version
    var customAdsMultiplier: CustomMultiplierType? = null,
    @ByteEnumUntil("45.0.0") // TODO find exact version
    var defaultAdsMultiplier: CustomMultiplierType? = null
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClubWarsPracticeFinishRace(
    session: GameConnection,
    request: ClubWarsPracticeFinishRaceRequest
) {
    session.sendResponse(ClubWarsPracticeFinishRaceResponse())
}