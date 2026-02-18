package moe.crx.roadblock.objects.clubwars

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class ClubWarsRegionDefenseNodeData : RObject {

    var defenseAttempts: Short = 0
    var assignedCar: Int = 0
    var currentlyOccupying: Boolean = false

    override fun read(sink: InputSink) {
        defenseAttempts = sink.readShort()
        assignedCar = sink.readInt()
        currentlyOccupying = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeShort(defenseAttempts)
        sink.writeInt(assignedCar)
        sink.writeBoolean(currentlyOccupying)
    }
}