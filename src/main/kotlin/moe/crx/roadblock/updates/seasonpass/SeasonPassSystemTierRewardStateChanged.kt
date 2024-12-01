package moe.crx.roadblock.updates.seasonpass

import moe.crx.roadblock.io.EnumIO.readEnum8
import moe.crx.roadblock.io.EnumIO.writeEnum8
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.SeasonPassTierId
import moe.crx.roadblock.objects.seasonpass.SeasonPassTierRewardState
import moe.crx.roadblock.objects.seasonpass.SeasonPassTierRewardType

class SeasonPassSystemTierRewardStateChanged : RObject {

    var eventId: CalendarEventId = ""
    var tier: SeasonPassTierId = 0
    var type: SeasonPassTierRewardType = SeasonPassTierRewardType.Free
    var newState: SeasonPassTierRewardState = SeasonPassTierRewardState.Locked

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        tier = sink.readByte()
        type = sink.readEnum8()
        newState = sink.readEnum8()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeByte(tier)
        sink.writeEnum8(type)
        sink.writeEnum8(newState)
    }
}