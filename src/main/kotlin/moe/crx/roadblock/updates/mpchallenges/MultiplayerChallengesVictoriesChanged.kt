package moe.crx.roadblock.updates.mpchallenges

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class MultiplayerChallengesVictoriesChanged : RObject {

    var eventId: Int = 0
    var oldVictories: Byte = 0
    var newVictories: Byte = 0

    override fun read(sink: InputSink) {
        eventId = sink.readInt()
        oldVictories = sink.readByte()
        newVictories = sink.readByte()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(eventId)
        sink.writeByte(oldVictories)
        sink.writeByte(newVictories)
    }
}