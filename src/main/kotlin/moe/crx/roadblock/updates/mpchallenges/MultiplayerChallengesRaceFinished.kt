package moe.crx.roadblock.updates.mpchallenges

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.mpchallenges.MultiplayerChallengeRaceResult

class MultiplayerChallengesRaceFinished : RObject {

    var raceResult: MultiplayerChallengeRaceResult = MultiplayerChallengeRaceResult()

    override fun read(sink: InputSink) {
        raceResult = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(raceResult)
    }
}