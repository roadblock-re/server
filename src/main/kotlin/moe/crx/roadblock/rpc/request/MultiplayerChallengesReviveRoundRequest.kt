package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.mpchallenges.MultiplayerChallengeFee
import moe.crx.roadblock.rpc.base.RequestPacket

class MultiplayerChallengesReviveRoundRequest : RequestPacket() {

    var eventId: CalendarEventId = ""
    var fee: MultiplayerChallengeFee = MultiplayerChallengeFee()

    override fun read(sink: InputSink) {
        super.read(sink)
        eventId = sink.readString()
        fee = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(eventId)
        sink.writeObject(fee)
    }
}