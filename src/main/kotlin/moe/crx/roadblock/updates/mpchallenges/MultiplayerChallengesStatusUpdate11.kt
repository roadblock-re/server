package moe.crx.roadblock.updates.mpchallenges

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class MultiplayerChallengesStatusUpdate11 : RObject {

    var eventId: Int = 0
    var cooldownUntil: Instant = now()

    override fun read(sink: InputSink) {
        eventId = sink.readInt()
        cooldownUntil = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(eventId)
        sink.writeInstant(cooldownUntil)
    }
}