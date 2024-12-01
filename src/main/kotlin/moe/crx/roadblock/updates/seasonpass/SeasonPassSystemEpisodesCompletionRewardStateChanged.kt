package moe.crx.roadblock.updates.seasonpass

import moe.crx.roadblock.io.EnumIO.readEnum8
import moe.crx.roadblock.io.EnumIO.writeEnum8
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.seasonpass.SeasonPassEpisodesCompletionRewardState

class SeasonPassSystemEpisodesCompletionRewardStateChanged : RObject {

    var eventId: CalendarEventId = ""
    var newState: SeasonPassEpisodesCompletionRewardState = SeasonPassEpisodesCompletionRewardState.Locked

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        newState = sink.readEnum8()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeEnum8(newState)
    }
}