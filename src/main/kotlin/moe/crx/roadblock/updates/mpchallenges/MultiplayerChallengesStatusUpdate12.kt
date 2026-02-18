package moe.crx.roadblock.updates.mpchallenges

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class MultiplayerChallengesStatusUpdate12 : RObject {

    var boxId: Short = 0

    override fun read(sink: InputSink) {
        boxId = sink.readShort()
    }

    override fun write(sink: OutputSink) {
        sink.writeShort(boxId)
    }
}