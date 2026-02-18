package moe.crx.roadblock.objects.game

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class LatencySample : RObject {

    var info: LatencyInfo = LatencyInfo()
    var ts: Instant = now()

    override fun read(sink: InputSink) {
        info = sink.readObject()
        ts = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(info)
        sink.writeInstant(ts)
    }
}