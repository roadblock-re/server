package moe.crx.roadblock.objects.championship

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.objects.ChampionshipRoundId
import moe.crx.roadblock.objects.EventTrackDefId

@Serializable
data class ChampionshipSpecialEventData(
    var qualifyingData: ChampionshipQualifyingStageData,
    var finalsData: ChampionshipFinalsStageData,
    var registeredFromRound: ChampionshipRoundId,
    var isQualified: Boolean,
    var qualifiedInRound: ChampionshipRoundId,
    var claimData: ChampionshipClaimData,
    var nextFreePackClaimTimePoint: Instant,
    var needsSyncServices: Boolean,
    var forceBan: Boolean,
    var pushNotificationCount: UInt,
    var usedDebugSuffix: Set<String>,
    @FromVersion("3.6.0")
    var nitroGhostResetCount: UInt = 0u,
    @FromVersion("3.9.0")
    var bestNitroGhostTimePerTrackDef: Map<EventTrackDefId, UInt> = mapOf(),
)