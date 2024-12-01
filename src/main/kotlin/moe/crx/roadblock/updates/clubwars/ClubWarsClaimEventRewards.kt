package moe.crx.roadblock.updates.clubwars

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.ClubWarsRewardIndex

class ClubWarsClaimEventRewards : RObject {

    var eventId: CalendarEventId = ""
    var rewardIdx: ClubWarsRewardIndex = 0

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        rewardIdx = sink.readByte()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeByte(rewardIdx)
    }
}