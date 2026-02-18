package moe.crx.roadblock.updates.mpchallenges

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class MultiplayerChallengesStatusUpdate0 : RObject {

    var eventId: Int = 0
    var victories: Byte = 0
    var useSeasonPass: Boolean = false
    var sponsorsSeed: Int = 0

    override fun read(sink: InputSink) {
        eventId = sink.readInt()
        victories = sink.readByte()
        useSeasonPass = sink.readBoolean()
        sponsorsSeed = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(eventId)
        sink.writeByte(victories)
        sink.writeBoolean(useSeasonPass)
        sink.writeInt(sponsorsSeed)
    }
}