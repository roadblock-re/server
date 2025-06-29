package moe.crx.roadblock.objects.championship

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject

class ChampionshipQualifyingStageData : RObject {

    var rounds: List<ChampionshipQualifyingRoundData> = listOf()
    var bestPracticeRace: ChampionshipRaceData = ChampionshipRaceData()
    var obtainedRewardCounts: List<RInt> = listOf()

    override fun read(sink: InputSink) {
        rounds = sink.readList()
        bestPracticeRace = sink.readObject()
        obtainedRewardCounts = sink.readList()
    }

    override fun write(sink: OutputSink) {
        sink.writeList(rounds)
        sink.writeObject(bestPracticeRace)
        sink.writeList(obtainedRewardCounts)
    }
}