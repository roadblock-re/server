package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.QuarantineData
import moe.crx.roadblock.objects.game.RaceStats
import moe.crx.roadblock.objects.game.RaceToken
import moe.crx.roadblock.rpc.base.RequestPacket

class PrivateLobbyFinishRaceRequest : RequestPacket() {

    var race: RaceToken = 0
    var stats: RaceStats = RaceStats()
    var quarantineData: QuarantineData = QuarantineData()
    var playback: ByteArray = ByteArray(0)
    var worstRTTMicroseconds: Int = 0
    var averageRTTMicroseconds: Int = 0
    var isRTTInformationReliable: Byte = 0
    var numberOfRacers: Int = 0
    var gridSpotIndex: Int = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        race = sink.readInt()
        stats = sink.readObject()
        quarantineData = sink.readObject()
        playback = sink.readByteArray()
        worstRTTMicroseconds = sink.readInt()
        averageRTTMicroseconds = sink.readInt()
        isRTTInformationReliable = sink.readByte()
        numberOfRacers = sink.readInt()
        gridSpotIndex = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(race)
        sink.writeObject(stats)
        sink.writeObject(quarantineData)
        sink.writeByteArray(playback)
        sink.writeInt(worstRTTMicroseconds)
        sink.writeInt(averageRTTMicroseconds)
        sink.writeByte(isRTTInformationReliable)
        sink.writeInt(numberOfRacers)
        sink.writeInt(gridSpotIndex)
    }
}