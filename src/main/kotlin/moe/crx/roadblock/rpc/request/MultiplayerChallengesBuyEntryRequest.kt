package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.mpchallenges.MultiplayerChallengeFee
import moe.crx.roadblock.rpc.base.RequestPacket

class MultiplayerChallengesBuyEntryRequest : RequestPacket() {

    var eventId: CalendarEventId = ""
    var entryPointId: Byte = 0
    var entryFee: MultiplayerChallengeFee = MultiplayerChallengeFee()
    var isFreeWithSeasonPass: Boolean = false

    override fun read(sink: InputSink) {
        super.read(sink)
        eventId = sink.readString()
        entryPointId = sink.readByte()
        entryFee = sink.readObject()
        isFreeWithSeasonPass = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(eventId)
        sink.writeByte(entryPointId)
        sink.writeObject(entryFee)
        sink.writeBoolean(isFreeWithSeasonPass)
    }
}