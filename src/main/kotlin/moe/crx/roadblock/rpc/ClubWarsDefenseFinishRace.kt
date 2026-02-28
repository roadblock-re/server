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
data class ClubWarsDefenseFinishRaceRequest(
    var raceToken: RaceToken,
    var stats: RaceStats,
    var quarantineData: QuarantineData,
    var playback: Blob,
    var debugSuffix: String,
) : RequestPacket()

@Serializable
data class ClubWarsDefenseFinishRaceResponse(
    @ByteEnum
    var customAdsMultiplier: CustomMultiplierType? = null,
    @ByteEnum
    var defaultAdsMultiplier: CustomMultiplierType? = null,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClubWarsDefenseFinishRace(
    session: GameConnection,
    request: ClubWarsDefenseFinishRaceRequest
) {
    session.sendResponse(ClubWarsDefenseFinishRaceResponse())
}