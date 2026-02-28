package moe.crx.roadblock.objects.gauntlet

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.CarRank
import moe.crx.roadblock.objects.EventTrackDefId
import moe.crx.roadblock.objects.GauntletChallengePoints
import moe.crx.roadblock.objects.GauntletDivision
import moe.crx.roadblock.objects.GauntletLeague
import moe.crx.roadblock.objects.GauntletQualificationId
import moe.crx.roadblock.objects.GauntletScore
import moe.crx.roadblock.objects.GauntletTicket
import moe.crx.roadblock.objects.quarantine.QuarantineEvidenceType

@Serializable
data class GauntletEventState(
    var division: GauntletDivision,
    var league: GauntletLeague,
    var opponentSets: List<List<GauntletOpponent?>>,
    var opponentSetsExpirationTime: Instant,
    var tracks: List<EventTrackDefId>,
    var defenceLog: List<GauntletDefenceEntry>,
    var challengeLog: List<GauntletChallengeEntry>,
    var qualificationData: Map<Short, GauntletQualificationData>,
    var currentChallenge: GauntletChallengeEntry?,
    var refreshTime: Instant,
    var challengePoints: GauntletChallengePoints,
    var rerollsCount: UInt,
    var ticketsPurchased: GauntletTicket,
    var tickets: UShort,
    var score: GauntletScore,
    var isClaimed: Boolean,
    var evidenceThreshold: Float,
    var evidenceWeightMultiplier: Float,
    var evidences: Map<QuarantineEvidenceType, GauntletEvidenceData>,
    var banTypes: List<UInt>,
    var currentRevenge: Instant?,
    var opponentsRefreshTime: Instant,
    var leaderboardDivision: String?,
    var totalCarRank: CarRank,
    var needToRePostBanScore: Boolean,
    var currentQualificationId: GauntletQualificationId,
    var matchmakingBlacklist: Map<ULong, Boolean>,
    var freeQualificationUsed: Boolean,
)