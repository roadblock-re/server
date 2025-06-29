package moe.crx.roadblock.objects.stats

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class TimeAttackStats : RObject {

    var timeLeft: Int = 0
    var highestCheckpointReached: Int = 0
    var hasFinishedRace: Byte = 0

    override fun read(sink: InputSink) {
        timeLeft = sink.readInt()
        highestCheckpointReached = sink.readInt()
        hasFinishedRace = sink.readByte()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(timeLeft)
        sink.writeInt(highestCheckpointReached)
        sink.writeByte(hasFinishedRace)
    }
}