package moe.crx.roadblock.objects.stats

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class TakedownStats : RObject {

    var hasCompletedRace: Byte = 0
    var eliminatedVictims: Int = 0
    var remainingTime: Int = 0
    var isPolice: Byte = 0
    var remainingLives: Byte = 0

    override fun read(sink: InputSink) {
        isPolice = sink.readByte()
        remainingLives = sink.readByte()
        hasCompletedRace = sink.readByte()
        eliminatedVictims = sink.readInt()
        remainingTime = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeByte(isPolice)
        sink.writeByte(remainingLives)
        sink.writeByte(hasCompletedRace)
        sink.writeInt(eliminatedVictims)
        sink.writeInt(remainingTime)
    }
}