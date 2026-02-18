package moe.crx.roadblock.objects.models

import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.io.MapIO.readMap
import moe.crx.roadblock.game.io.MapIO.writeMap
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.mpchallenges.MultiplayerChallenge

class MultiplayerChallengesState : RObject {

    var challenges: Map<RInt, MultiplayerChallenge> = mapOf()
    var currentEventId: String = ""
    var alreadyProcessedRaceTokens: List<RInt> = listOf()

    override fun read(sink: InputSink) {
        challenges = sink.readMap()
        currentEventId = sink.readString()
        alreadyProcessedRaceTokens = sink.readList()
    }

    override fun write(sink: OutputSink) {
        sink.writeMap(challenges)
        sink.writeString(currentEventId)
        sink.writeList(alreadyProcessedRaceTokens)
    }
}