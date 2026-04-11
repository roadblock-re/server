package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.Blob
import moe.crx.roadblock.game.serialization.ByteEnumUntil
import moe.crx.roadblock.objects.RaceToken
import moe.crx.roadblock.objects.multiplayer.RaceStats
import moe.crx.roadblock.objects.transactions.CustomMultiplierType
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class TournamentFinishRaceRequest(
    var race: RaceToken,
    var stats: RaceStats,
    var playback: Blob,
    var worstRTTMicroseconds: UInt,
    var averageRTTMicroseconds: UInt,
    var isRTTInformationReliable: Boolean,
    var numberOfRacers: UInt,
    var gridSpotIndex: UInt,
) : RequestPacket()

@Serializable
data class TournamentFinishRaceResponse(
    @ByteEnumUntil("45.0.0") // TODO find exact version
    var customAdsMultiplier: CustomMultiplierType? = null,
    @ByteEnumUntil("45.0.0") // TODO find exact version
    var defaultAdsMultiplier: CustomMultiplierType? = null,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleTournamentFinishRace(
    session: GameConnection,
    request: TournamentFinishRaceRequest
) {
    session.sendResponse(TournamentFinishRaceResponse())
}