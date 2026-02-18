package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.RaceToken
import moe.crx.roadblock.rpc.base.RequestPacket

class PrivateLobbyStartRaceSpectatorRequest : RequestPacket() {

    var raceToken: RaceToken = 0
    var roomId: String = ""

    override fun read(sink: InputSink) {
        super.read(sink)
        raceToken = sink.readInt()
        roomId = sink.readString()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(raceToken)
        sink.writeString(roomId)
    }
}