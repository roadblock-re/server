package moe.crx.roadblock.objects.tle

import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class TLEventQuarantineData : RObject {

    var leaderboardName: String = ""
    var raceData: TLEventRaceData = TLEventRaceData()

    override fun read(sink: InputSink) {
        leaderboardName = sink.readString()
        raceData = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(leaderboardName)
        sink.writeObject(raceData)
    }
}