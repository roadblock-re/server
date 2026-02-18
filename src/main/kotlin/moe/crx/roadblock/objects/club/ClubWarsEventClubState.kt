package moe.crx.roadblock.objects.club

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class ClubWarsEventClubState : RObject {

    var roundId: Byte = 0
    var joinedTimestamp: Instant = now()
    var lastFinishedRoundIndex: Byte = 0
    var eventScoreAfterLastFinishedRound: Int = 0

    override fun read(sink: InputSink) {
        roundId = sink.readByte()
        joinedTimestamp = sink.readInstant()
        lastFinishedRoundIndex = sink.readByte()
        eventScoreAfterLastFinishedRound = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeByte(roundId)
        sink.writeInstant(joinedTimestamp)
        sink.writeByte(lastFinishedRoundIndex)
        sink.writeInt(eventScoreAfterLastFinishedRound)
    }
}