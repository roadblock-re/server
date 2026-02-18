package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.QuarantineData
import moe.crx.roadblock.objects.game.RaceStats
import moe.crx.roadblock.objects.game.RaceToken
import moe.crx.roadblock.rpc.base.RequestPacket

class UberSpecialEventCommitResultsRaceRequest : RequestPacket() {

    var raceToken: RaceToken = 0
    var stats: RaceStats = RaceStats()
    var quarantineData: QuarantineData = QuarantineData()
    var playback: ByteArray = ByteArray(0)

    override fun read(sink: InputSink) {
        super.read(sink)
        raceToken = sink.readInt()
        stats = sink.readObject()
        quarantineData = sink.readObject()
        playback = sink.readByteArray()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(raceToken)
        sink.writeObject(stats)
        sink.writeObject(quarantineData)
        sink.writeByteArray(playback)
    }
}