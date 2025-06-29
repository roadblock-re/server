package moe.crx.roadblock.objects.championship

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.MapIO.readMap
import moe.crx.roadblock.io.MapIO.writeMap
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.ChampionshipGroupId

class ChampionshipQualifyingRoundData : RObject {

    var groupId: ChampionshipGroupId = 0
    var attemptCount: Byte = 0
    var bestRace: ChampionshipRaceData = ChampionshipRaceData()
    var leaderboard: ChampionshipLeaderboardData = ChampionshipLeaderboardData()
    var evidences: Map<RInt, ChampionshipEvidenceData> = mapOf()
    var isDisqualified: Boolean = false
    var state: ChampionshipRoundState = ChampionshipRoundState.Unknown

    override fun read(sink: InputSink) {
        groupId = sink.readInt()
        attemptCount = sink.readByte()
        bestRace = sink.readObject()
        leaderboard = sink.readObject()
        evidences = sink.readMap()
        isDisqualified = sink.readBoolean()
        state = sink.readEnum()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(groupId)
        sink.writeByte(attemptCount)
        sink.writeObject(bestRace)
        sink.writeObject(leaderboard)
        sink.writeMap(evidences)
        sink.writeBoolean(isDisqualified)
        sink.writeEnum(state)
    }

}
