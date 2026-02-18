package moe.crx.roadblock.updates.multiplayer

import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.multiplayer.MultiplayerSeriesRaceResult

class MultiplayerSeriesRaceFinished : RObject {

    var raceResult: MultiplayerSeriesRaceResult = MultiplayerSeriesRaceResult()

    override fun read(sink: InputSink) {
        raceResult = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(raceResult)
    }
}