package moe.crx.roadblock.updates.mpchallenges

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class MultiplayerChallengesDefeatsChanged : RObject {

    var eventId: Int = 0
    var oldDefeats: Byte = 0
    var newDefeats: Byte = 0

    override fun read(sink: InputSink) {
        eventId = sink.readInt()
        oldDefeats = sink.readByte()
        newDefeats = sink.readByte()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(eventId)
        sink.writeByte(oldDefeats)
        sink.writeByte(newDefeats)
    }
}