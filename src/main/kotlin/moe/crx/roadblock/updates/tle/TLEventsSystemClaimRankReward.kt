package moe.crx.roadblock.updates.tle

import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.tle.TLEventId

class TLEventsSystemClaimRankReward : RObject {

    var eventId: TLEventId = TLEventId()
    var rewardIdx: Byte = 0

    override fun read(sink: InputSink) {
        eventId = sink.readObject()
        rewardIdx = sink.readByte()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(eventId)
        sink.writeByte(rewardIdx)
    }
}