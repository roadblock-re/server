package moe.crx.roadblock.objects.gauntlet

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RFloat
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.Credentials

class GauntletChallengeEntry : RObject {

    var tracks: List<RInt> = listOf()
    var myStats: List<GauntletRaceStats> = listOf()
    var opStats: List<GauntletRaceStats> = listOf()
    var opCredentials: Credentials = Credentials()
    var myScore: Short = 0
    var opScore: Short = 0
    var challengePoints: Short = 0
    var loseChallengePoints: Short = 0
    var eloK: Float = 0f
    var eloTa: List<RFloat> = listOf()
    var eloTd: List<RFloat> = listOf()
    var timestamp: Instant = now()
    var numFinished: Int = 0
    var challengeType: Int = 0
    var qualId: Short = 0

    override fun read(sink: InputSink) {
        tracks = sink.readList()
        myStats = sink.readList()
        opStats = sink.readList()
        opCredentials = sink.readObject()
        myScore = sink.readShort()
        opScore = sink.readShort()
        challengePoints = sink.readShort()
        loseChallengePoints = sink.readShort()
        eloK = sink.readFloat()
        eloTa = sink.readList()
        eloTd = sink.readList()
        timestamp = sink.readInstant()
        numFinished = sink.readInt()
        challengeType = sink.readInt()
        qualId = sink.readShort()
    }

    override fun write(sink: OutputSink) {
        sink.writeList(tracks)
        sink.writeList(myStats)
        sink.writeList(opStats)
        sink.writeObject(opCredentials)
        sink.writeShort(myScore)
        sink.writeShort(opScore)
        sink.writeShort(challengePoints)
        sink.writeShort(loseChallengePoints)
        sink.writeFloat(eloK)
        sink.writeList(eloTa)
        sink.writeList(eloTd)
        sink.writeInstant(timestamp)
        sink.writeInt(numFinished)
        sink.writeInt(challengeType)
        sink.writeShort(qualId)
    }

}
