package moe.crx.roadblock.objects.stats

import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class MultiplayerTakedownStats : RObject {

    // TODO verify members order
    var playerStats: TakedownStats = TakedownStats()
    var didPoliceWin: Byte = 0
    var totalTakedowns: Int = 0
    var requiredTakedowns: Int = 0

    override fun read(sink: InputSink) {
        playerStats = sink.readObject()
        didPoliceWin = sink.readByte()
        totalTakedowns = sink.readInt()
        requiredTakedowns = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(playerStats)
        sink.writeByte(didPoliceWin)
        sink.writeInt(totalTakedowns)
        sink.writeInt(requiredTakedowns)
    }
}