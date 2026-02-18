package moe.crx.roadblock.objects.championship

import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.io.MapIO.readMap
import moe.crx.roadblock.game.io.MapIO.writeMap
import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.ChampionshipPoints

class ChampionshipFinalsRoundData : RObject {

    var attemptCount: Byte = 0
    var bestPracticeRace: ChampionshipRaceData = ChampionshipRaceData()
    var bestRace: ChampionshipRaceData = ChampionshipRaceData()
    var leaderboard: ChampionshipLeaderboardData = ChampionshipLeaderboardData()
    var obtainedRewardCounts: List<RInt> = listOf()
    var evidences: Map<RInt, ChampionshipEvidenceData> = mapOf()
    var isDisqualified: Boolean = false
    var state: ChampionshipRoundState = ChampionshipRoundState.Unknown
    var points: ChampionshipPoints = 0

    override fun read(sink: InputSink) {
        attemptCount = sink.readByte()
        if (sink newer "45.0.0") {
            obtainedRewardCounts = sink.readList()
        }
        bestPracticeRace = sink.readObject()
        bestRace = sink.readObject()
        leaderboard = sink.readObject()
        if (sink older "45.0.0") {
            obtainedRewardCounts = sink.readList()
        }
        evidences = sink.readMap()
        isDisqualified = sink.readBoolean()
        state = sink.readEnum()
        points = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeByte(attemptCount)
        if (sink newer "45.0.0") {
            sink.writeList(obtainedRewardCounts)
        }
        sink.writeObject(bestPracticeRace)
        sink.writeObject(bestRace)
        sink.writeObject(leaderboard)
        if (sink older "45.0.0") {
            sink.writeList(obtainedRewardCounts)
        }
        sink.writeMap(evidences)
        sink.writeBoolean(isDisqualified)
        sink.writeEnum(state)
        sink.writeInt(points)
    }
}