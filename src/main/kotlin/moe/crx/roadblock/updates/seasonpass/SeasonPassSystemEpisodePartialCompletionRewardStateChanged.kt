package moe.crx.roadblock.updates.seasonpass

import moe.crx.roadblock.game.io.EnumIO.readEnum8
import moe.crx.roadblock.game.io.EnumIO.writeEnum8
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.SeasonPassEpisodeId
import moe.crx.roadblock.objects.seasonpass.SeasonPassEpisodePartialCompletionRewardState

class SeasonPassSystemEpisodePartialCompletionRewardStateChanged : RObject {

    var eventId: CalendarEventId = ""
    var episodeId: SeasonPassEpisodeId = 0
    var newState: SeasonPassEpisodePartialCompletionRewardState = SeasonPassEpisodePartialCompletionRewardState.Locked

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        episodeId = sink.readByte()
        newState = sink.readEnum8()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeByte(episodeId)
        sink.writeEnum8(newState)
    }
}