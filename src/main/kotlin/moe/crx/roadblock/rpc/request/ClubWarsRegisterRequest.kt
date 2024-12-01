package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.clubwars.ClubWarsRegisterDebugOption
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.ClubWarsRoundIndex
import moe.crx.roadblock.rpc.base.RequestPacket

class ClubWarsRegisterRequest : RequestPacket() {

    var eventId: CalendarEventId = ""
    var roundId: ClubWarsRoundIndex = 0
    var debugOptions: ClubWarsRegisterDebugOption = ClubWarsRegisterDebugOption()
    var debugSuffix: String = ""

    override fun read(sink: InputSink) {
        super.read(sink)
        eventId = sink.readString()
        roundId = sink.readByte()
        debugOptions = sink.readObject()
        debugSuffix = sink.readString()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(eventId)
        sink.writeByte(roundId)
        sink.writeObject(debugOptions)
        sink.writeString(debugSuffix)
    }
}