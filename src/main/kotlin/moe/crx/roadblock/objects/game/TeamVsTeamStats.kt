package moe.crx.roadblock.objects.game

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class TeamVsTeamStats : RObject {

    var teamId: Int = 0
    var points: Int = 0

    override fun read(sink: InputSink) {
        teamId = sink.readInt()
        points = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(teamId)
        sink.writeInt(points)
    }

}
