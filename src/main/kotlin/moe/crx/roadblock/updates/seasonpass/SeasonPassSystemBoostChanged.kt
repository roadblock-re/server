package moe.crx.roadblock.updates.seasonpass

import moe.crx.roadblock.game.io.EnumIO.readEnum8
import moe.crx.roadblock.game.io.EnumIO.writeEnum8
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.SeasonPassBenefitBoost
import moe.crx.roadblock.objects.seasonpass.SeasonPassBoostType

class SeasonPassSystemBoostChanged : RObject {

    var eventId: CalendarEventId = ""
    var type: SeasonPassBoostType = SeasonPassBoostType.Reputation
    var oldBoost: SeasonPassBenefitBoost = 0
    var newBoost: SeasonPassBenefitBoost = 0

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        type = sink.readEnum8()
        oldBoost = sink.readInt()
        newBoost = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeEnum8(type)
        sink.writeInt(oldBoost)
        sink.writeInt(newBoost)
    }

}