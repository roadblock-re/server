package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.RaceToken
import moe.crx.roadblock.rpc.base.RequestPacket

class ClubRaceCancelRaceRequest : RequestPacket() {

    var raceToken: RaceToken = 0
    var raceTimeMicroseconds: Int = 0
    var worstRTTMicroseconds: Int = 0
    var averageRTTMicroseconds: Int = 0
    var isRTTInformationReliable: Byte = 0
    var numberOfRacers: Int = 0
    var gridSpotIndex: Int = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        raceToken = sink.readInt()
        raceTimeMicroseconds = sink.readInt()
        worstRTTMicroseconds = sink.readInt()
        averageRTTMicroseconds = sink.readInt()
        isRTTInformationReliable = sink.readByte()
        numberOfRacers = sink.readInt()
        gridSpotIndex = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(raceToken)
        sink.writeInt(raceTimeMicroseconds)
        sink.writeInt(worstRTTMicroseconds)
        sink.writeInt(averageRTTMicroseconds)
        sink.writeByte(isRTTInformationReliable)
        sink.writeInt(numberOfRacers)
        sink.writeInt(gridSpotIndex)
    }
}