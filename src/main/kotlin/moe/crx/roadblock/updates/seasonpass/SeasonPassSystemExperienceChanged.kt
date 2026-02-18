package moe.crx.roadblock.updates.seasonpass

import moe.crx.roadblock.game.io.EnumIO.readEnum8
import moe.crx.roadblock.game.io.EnumIO.writeEnum8
import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RByte
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.SeasonPassExperience
import moe.crx.roadblock.objects.seasonpass.SeasonPassExperienceOrigin

class SeasonPassSystemExperienceChanged : RObject {

    var eventId: CalendarEventId = ""
    var oldExperience: SeasonPassExperience = 0
    var newExperience: SeasonPassExperience = 0
    var origin: SeasonPassExperienceOrigin = SeasonPassExperienceOrigin.MissionCompleted
    var legendPassType: RByte? = null //SeasonPassLegendPassType
    var legendPassExtraExperience: RInt? = null // SeasonPassExperience

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        oldExperience = sink.readInt()
        newExperience = sink.readInt()
        origin = sink.readEnum8()
        legendPassType = sink.readOptional()
        legendPassExtraExperience = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeInt(oldExperience)
        sink.writeInt(newExperience)
        sink.writeEnum8(origin)
        sink.writeOptional(legendPassType)
        sink.writeOptional(legendPassExtraExperience)
    }
}