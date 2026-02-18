package moe.crx.roadblock.updates.multiplayer

import moe.crx.roadblock.game.io.EnumIO.readEnum8
import moe.crx.roadblock.game.io.EnumIO.writeEnum8
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.MultiplayerSeriesScoreMilestoneId
import moe.crx.roadblock.objects.multiplayer.MultiplayerSeriesScoreMilestoneRewardState

class MultiplayerSeriesMilestoneChanged : RObject {

    var eventId: CalendarEventId = ""
    var milestoneId: MultiplayerSeriesScoreMilestoneId = 0
    var state: MultiplayerSeriesScoreMilestoneRewardState = MultiplayerSeriesScoreMilestoneRewardState.Locked
    var isBonusPassExclusive: Boolean = false

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        milestoneId = sink.readByte()
        state = sink.readEnum8()
        isBonusPassExclusive = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeByte(milestoneId)
        sink.writeEnum8(state)
        sink.writeBoolean(isBonusPassExclusive)
    }
}