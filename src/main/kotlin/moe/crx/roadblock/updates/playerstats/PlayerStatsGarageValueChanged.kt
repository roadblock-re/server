package moe.crx.roadblock.updates.playerstats

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.GarageValue

class PlayerStatsGarageValueChanged : RObject {

    var oldValue: GarageValue = 0
    var newValue: GarageValue = 0

    override fun read(sink: InputSink) {
        oldValue = sink.readInt()
        newValue = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(oldValue)
        sink.writeInt(newValue)
    }
}