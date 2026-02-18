package moe.crx.roadblock.objects.gauntlet

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.Credentials

class GauntletDefenceEntry : RObject {

    var myStats: List<GauntletRaceStats> = listOf()
    var opStats: List<GauntletRaceStats> = listOf()
    var opCredentials: Credentials = Credentials()
    var myScore: Short = 0
    var opScore: Short = 0
    var timestamp: Instant = now()
    var revengeState: Int = 0
    var dScore: Short = 0

    override fun read(sink: InputSink) {
        myStats = sink.readList()
        opStats = sink.readList()
        opCredentials = sink.readObject()
        myScore = sink.readShort()
        opScore = sink.readShort()
        timestamp = sink.readInstant()
        revengeState = sink.readInt()
        dScore = sink.readShort()
    }

    override fun write(sink: OutputSink) {
        sink.writeList(myStats)
        sink.writeList(opStats)
        sink.writeObject(opCredentials)
        sink.writeShort(myScore)
        sink.writeShort(opScore)
        sink.writeInstant(timestamp)
        sink.writeInt(revengeState)
        sink.writeShort(dScore)
    }

}
