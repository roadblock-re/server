package moe.crx.roadblock.objects.gauntlet

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.Credentials

class GauntletOpponent : RObject {

    var tracks: List<RInt> = listOf()
    var stats: List<GauntletRaceStats> = listOf()
    var score: Short = 0
    var qualId: Short = 0
    var credentials: Credentials = Credentials()

    override fun read(sink: InputSink) {
        tracks = sink.readList()
        stats = sink.readList()
        score = sink.readShort()
        qualId = sink.readShort()
        credentials = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        sink.writeList(tracks)
        sink.writeList(stats)
        sink.writeShort(score)
        sink.writeShort(qualId)
        sink.writeObject(credentials)
    }

}
