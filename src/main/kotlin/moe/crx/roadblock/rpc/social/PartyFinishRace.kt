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
data class PartyFinishRaceRequest(
    var race: RaceToken,
    var stats: RaceStats,
    var quarantineData: QuarantineData,
    var playback: Blob,
    var worstRTTMicroseconds: UInt,
    var averageRTTMicroseconds: UInt,
    var isRTTInformationReliable: Boolean,
    var numberOfRacers: UInt,
    var gridSpotIndex: UInt,
) : RequestPacket()

@Serializable
data class PartyFinishRaceResponse(
    @FromVersion("24.0.0") @ByteEnum
    var customAdsMultiplier: CustomMultiplierType? = null,
    @FromVersion("24.0.0") @ByteEnum
    var defaultAdsMultiplier: CustomMultiplierType? = null,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handlePartyFinishRace(
    session: GameConnection,
    request: PartyFinishRaceRequest
) {
    session.sendResponse(PartyFinishRaceResponse())
}