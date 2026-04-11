package moe.crx.roadblock.objects.tle

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.objects.EvoTryEventId

@Serializable
data class TLEventData(
    var soloData: SoloTLEventData,
    var rankData: RankTLEventData,
    var clubData: ClubTLEventData,
    var bestRace: TLEventRaceData,
    var quarantine: TLEventQuarantineData?,
    var timestamp: Instant,
    var forceQuarantine: Boolean,
    var isAutoClaimed: Boolean,
    @FromVersion("3.6.0")
    var nitroGhostResetCount: UInt = 0u,
    @FromVersion("3.9.0")
    var bestNitroGhostTimeInSeconds: UInt = 0u,
    @FromVersion("24.6.0")
    var lastRace: TLEventLastRace = TLEventLastRace(),
    @FromVersion("24.6.0")
    var autoplayData: TLEventAutoplayData? = null,
    @FromVersion("47.1.0")
    var evoFreeTryData: Map<EvoTryEventId, EvoFreeTryData> = mapOf(),
)