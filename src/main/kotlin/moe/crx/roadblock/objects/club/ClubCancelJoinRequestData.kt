package moe.crx.roadblock.objects.club

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class ClubCancelJoinRequestData : RObject {

    var reason: Int = 0
    var clubName: String = ""

    override fun read(sink: InputSink) {
        reason = sink.readInt()
        clubName = sink.readString()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(reason)
        sink.writeString(clubName)
    }
}