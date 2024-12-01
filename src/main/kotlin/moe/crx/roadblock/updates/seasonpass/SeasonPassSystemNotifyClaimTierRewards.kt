package moe.crx.roadblock.updates.seasonpass

import moe.crx.roadblock.io.EnumIO.readEnum8
import moe.crx.roadblock.io.EnumIO.writeEnum8
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.SeasonPassTierId
import moe.crx.roadblock.objects.seasonpass.SeasonPassTierRewardType

class SeasonPassSystemNotifyClaimTierRewards : RObject {

    var eventId: CalendarEventId = ""
    var tierId: SeasonPassTierId = 0
    var type: SeasonPassTierRewardType = SeasonPassTierRewardType.Free

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        tierId = sink.readByte()
        type = sink.readEnum8()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeByte(tierId)
        sink.writeEnum8(type)
    }
}