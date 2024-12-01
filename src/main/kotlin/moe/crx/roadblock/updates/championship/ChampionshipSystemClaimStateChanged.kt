package moe.crx.roadblock.updates.championship

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.championship.ChampionshipRoundState
import moe.crx.roadblock.objects.game.CalendarEventId

class ChampionshipSystemClaimStateChanged : RObject {

    var eventId: CalendarEventId = ""
    var state: ChampionshipRoundState = ChampionshipRoundState.Unknown
    var rewardIdx: Byte = 0

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        state = sink.readEnum()
        rewardIdx = sink.readByte()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeEnum(state)
        sink.writeByte(rewardIdx)
    }
}