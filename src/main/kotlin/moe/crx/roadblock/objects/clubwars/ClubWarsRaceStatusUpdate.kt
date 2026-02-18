package moe.crx.roadblock.objects.clubwars

import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class ClubWarsRaceStatusUpdate : RObject {

    var car: ClubWarsCarStatusUpdate = ClubWarsCarStatusUpdate()
    var time: Int = 0

    override fun read(sink: InputSink) {
        car = sink.readObject()
        time = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(car)
        sink.writeInt(time)
    }
}