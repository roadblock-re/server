package moe.crx.roadblock.updates.seasonpass

import moe.crx.roadblock.io.EnumIO.readEnum8
import moe.crx.roadblock.io.EnumIO.writeEnum8
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.SeasonPassEpisodeId
import moe.crx.roadblock.objects.game.SeasonPassMissionId
import moe.crx.roadblock.objects.seasonpass.SeasonPassMissionState

class SeasonPassSystemMissionStateChanged : RObject {

    var eventId: CalendarEventId = ""
    var episodeId: SeasonPassEpisodeId = 0
    var missionId: SeasonPassMissionId = 0
    var newState: SeasonPassMissionState = SeasonPassMissionState.Ready

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        episodeId = sink.readByte()
        missionId = sink.readShort()
        newState = sink.readEnum8()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeByte(episodeId)
        sink.writeShort(missionId)
        sink.writeEnum8(newState)
    }
}