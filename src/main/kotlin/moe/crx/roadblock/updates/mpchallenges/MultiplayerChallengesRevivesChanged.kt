package moe.crx.roadblock.updates.mpchallenges

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class MultiplayerChallengesRevivesChanged : RObject {

    var eventId: Int = 0
    var oldRevives: Byte = 0
    var newRevives: Byte = 0

    override fun read(sink: InputSink) {
        eventId = sink.readInt()
        oldRevives = sink.readByte()
        newRevives = sink.readByte()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(eventId)
        sink.writeByte(oldRevives)
        sink.writeByte(newRevives)
    }
}