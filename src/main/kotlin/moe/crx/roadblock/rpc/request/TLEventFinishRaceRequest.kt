package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.QuarantineData
import moe.crx.roadblock.objects.game.RaceStats
import moe.crx.roadblock.objects.game.RaceToken
import moe.crx.roadblock.rpc.base.RequestPacket

class TLEventFinishRaceRequest : RequestPacket() {

    var raceId: RaceToken = 0
    var raceStats: RaceStats = RaceStats()
    var quarantineData: QuarantineData = QuarantineData()
    var playback: ByteArray = ByteArray(0)

    override fun read(sink: InputSink) {
        super.read(sink)
        raceId = sink.readInt()
        raceStats = sink.readObject()
        quarantineData = sink.readObject()
        playback = sink.readByteArray()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(raceId)
        sink.writeObject(raceStats)
        sink.writeObject(quarantineData)
        sink.writeByteArray(playback)
    }
}