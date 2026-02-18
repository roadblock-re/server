package moe.crx.roadblock.updates.tle

import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.tle.TLEventId
import moe.crx.roadblock.objects.tle.TimeLimitedSpecialProgressionRewardState

class TLEventsSystemSpecialEventProgressionRewardStateChanged : RObject {

    var eventId: TLEventId = TLEventId()
    var rewardIdx: Byte = 0
    var newState: TimeLimitedSpecialProgressionRewardState = TimeLimitedSpecialProgressionRewardState.Locked

    override fun read(sink: InputSink) {
        eventId = sink.readObject()
        rewardIdx = sink.readByte()
        newState = sink.readEnum()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(eventId)
        sink.writeByte(rewardIdx)
        sink.writeEnum(newState)
    }
}