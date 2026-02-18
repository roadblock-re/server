package moe.crx.roadblock.objects.club

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class ClubSentRequestData : RObject {

    var requestId: String = ""
    var clubId: String = ""
    var clubName: String = ""

    override fun read(sink: InputSink) {
        requestId = sink.readString()
        clubId = sink.readString()
        clubName = sink.readString()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(requestId)
        sink.writeString(clubId)
        sink.writeString(clubName)
    }
}