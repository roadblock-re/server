package moe.crx.roadblock.objects.career

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject

class CareerEventState : RObject {

    var eventId: Int = 0
    var state: Int = 0
    var obtainedFlags: List<RInt> = listOf()
    var satelliteRewardState: RInt? = RInt()

    override fun read(sink: InputSink) {
        eventId = sink.readInt()
        state = sink.readInt()
        obtainedFlags = sink.readList()
        satelliteRewardState = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(eventId)
        sink.writeInt(state)
        sink.writeList(obtainedFlags)
        sink.writeOptional(satelliteRewardState)
    }
}