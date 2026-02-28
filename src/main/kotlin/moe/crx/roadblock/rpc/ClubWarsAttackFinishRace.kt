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
data class ClubWarsAttackFinishRaceRequest(
    var raceToken: RaceToken,
    var stats: RaceStats,
    var quarantineData: QuarantineData,
    var playback: Blob,
    var defenseRaceTime: UInt,
    var debugSuffix: String,
) : RequestPacket()

@Serializable
data class ClubWarsAttackFinishRaceResponse(
    @ByteEnum
    var customAdsMultiplier: CustomMultiplierType? = null,
    @ByteEnum
    var defaultAdsMultiplier: CustomMultiplierType? = null,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClubWarsAttackFinishRace(
    session: GameConnection,
    request: ClubWarsAttackFinishRaceRequest
) {
    session.sendResponse(ClubWarsAttackFinishRaceResponse())
}