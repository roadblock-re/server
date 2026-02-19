package moe.crx.roadblock.objects.tle

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.objects.account.EvoTryEventId

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
    var nitroGhostResetCount: UInt,
    var bestNitroGhostTimeInSeconds: UInt,
    @FromVersion("24.6.0")
    var lastRace: TLEventLastRace = TLEventLastRace(),
    @FromVersion("24.6.0")
    var autoplayData: TLEventAutoplayData? = null,
    @FromVersion("47.1.0")
    var evoFreeTryData: Map<EvoTryEventId, EvoFreeTryData> = mapOf(),
)