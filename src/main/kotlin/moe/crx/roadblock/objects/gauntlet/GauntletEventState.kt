package moe.crx.roadblock.objects.gauntlet

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.MapIO.readMap
import moe.crx.roadblock.io.MapIO.writeMap
import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.*
import moe.crx.roadblock.objects.game.CarRank

class GauntletEventState : RObject {

    var division: Byte = 0
    var league: Byte = 0
    var opponentSets: List<GauntletOpponentSet> = listOf()
    var opponentSetsExpirationTime: Instant = now()
    var tracks: List<RInt> = listOf()
    var defenceLog: List<GauntletDefenceEntry> = listOf()
    var challengeLog: List<GauntletChallengeEntry> = listOf()
    var qualificationData: Map<RShort, GauntletQualificationData> = mapOf()
    var optCurrentChallenge: GauntletChallengeEntry? = null
    var refreshTime: Instant = now()
    var challengePoints: Short = 0
    var rerollsCount: Int = 0
    var ticketsPurchased: Int = 0
    var tickets: Short = 0
    var score: Short = 0
    var isClaimed: Boolean = false
    var evidenceThreshold: Int = 0
    var evidenceWeightMultiplier: Int = 0
    var evidences: Map<RInt, GauntletEvidenceEntry> = mapOf()
    var banTypes: List<RInt> = listOf()
    var optCurrentRevenge: RInstant? = null
    var opponentsRefreshTime: Instant = now()
    var optLeaderboardDivision: RString? = null
    var totalCarRank: CarRank = 0
    var needToRePostBanScore: Boolean = false
    var currentQualificationId: Short = 0
    var matchmakingBlacklist: Map<RLong, RBoolean> = mapOf()
    var freeQualificationUsed: Boolean = false

    override fun read(sink: InputSink) {
        division = sink.readByte()
        league = sink.readByte()
        opponentSets = sink.readList()
        opponentSetsExpirationTime = sink.readInstant()
        tracks = sink.readList()
        defenceLog = sink.readList()
        challengeLog = sink.readList()
        qualificationData = sink.readMap()
        optCurrentChallenge = sink.readOptional()
        refreshTime = sink.readInstant()
        challengePoints = sink.readShort()
        rerollsCount = sink.readInt()
        ticketsPurchased = sink.readInt()
        tickets = sink.readShort()
        score = sink.readShort()
        isClaimed = sink.readBoolean()
        evidenceThreshold = sink.readInt()
        evidenceWeightMultiplier = sink.readInt()
        evidences = sink.readMap()
        banTypes = sink.readList()
        optCurrentRevenge = sink.readOptional()
        opponentsRefreshTime = sink.readInstant()
        optLeaderboardDivision = sink.readOptional()
        totalCarRank = sink.readShort()
        needToRePostBanScore = sink.readBoolean()
        currentQualificationId = sink.readShort()
        matchmakingBlacklist = sink.readMap()
        freeQualificationUsed = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeByte(division)
        sink.writeByte(league)
        sink.writeList(opponentSets)
        sink.writeInstant(opponentSetsExpirationTime)
        sink.writeList(tracks)
        sink.writeList(defenceLog)
        sink.writeList(challengeLog)
        sink.writeMap(qualificationData)
        sink.writeOptional(optCurrentChallenge)
        sink.writeInstant(refreshTime)
        sink.writeShort(challengePoints)
        sink.writeInt(rerollsCount)
        sink.writeInt(ticketsPurchased)
        sink.writeShort(tickets)
        sink.writeShort(score)
        sink.writeBoolean(isClaimed)
        sink.writeInt(evidenceThreshold)
        sink.writeInt(evidenceWeightMultiplier)
        sink.writeMap(evidences)
        sink.writeList(banTypes)
        sink.writeOptional(optCurrentRevenge)
        sink.writeInstant(opponentsRefreshTime)
        sink.writeOptional(optLeaderboardDivision)
        sink.writeShort(totalCarRank)
        sink.writeBoolean(needToRePostBanScore)
        sink.writeShort(currentQualificationId)
        sink.writeMap(matchmakingBlacklist)
        sink.writeBoolean(freeQualificationUsed)
    }
}