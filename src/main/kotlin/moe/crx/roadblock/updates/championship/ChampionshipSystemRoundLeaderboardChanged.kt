package moe.crx.roadblock.updates.championship

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.championship.ChampionshipStageType
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.ChampionshipRoundId
import moe.crx.roadblock.objects.game.LeaderboardPosition

class ChampionshipSystemRoundLeaderboardChanged : RObject {

    var eventId: CalendarEventId = ""
    var stageType: ChampionshipStageType = ChampionshipStageType.Qualifying
    var roundId: ChampionshipRoundId = 0
    var position: LeaderboardPosition = 0
    var timestamp: Instant = now()

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        stageType = sink.readEnum()
        roundId = sink.readInt()
        position = sink.readInt()
        timestamp = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeEnum(stageType)
        sink.writeInt(roundId)
        sink.writeInt(position)
        sink.writeInstant(timestamp)
    }
}