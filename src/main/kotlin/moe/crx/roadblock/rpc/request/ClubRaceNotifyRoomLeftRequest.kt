package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.ClubRaceRoomId
import moe.crx.roadblock.rpc.base.RequestPacket

class ClubRaceNotifyRoomLeftRequest : RequestPacket() {

    var roomId: ClubRaceRoomId = ""

    override fun read(sink: InputSink) {
        super.read(sink)
        roomId = sink.readString()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(roomId)
    }
}