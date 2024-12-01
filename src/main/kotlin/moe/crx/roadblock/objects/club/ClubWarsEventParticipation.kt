package moe.crx.roadblock.objects.club

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.ClubWarsPoints

class ClubWarsEventParticipation : RObject {

    var score: ClubWarsPoints = 0
    var roundId: Byte = 0
    var joinTimestamp: Instant = now()
    var eventScoreAfterLastFinishedRound: ClubWarsPoints = 0
    var lastFinishedRoundIndex: Byte = 0

    override fun read(sink: InputSink) {
        score = sink.readInt()
        roundId = sink.readByte()
        joinTimestamp = sink.readInstant()
        eventScoreAfterLastFinishedRound = sink.readInt()
        lastFinishedRoundIndex = sink.readByte()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(score)
        sink.writeByte(roundId)
        sink.writeInstant(joinTimestamp)
        sink.writeInt(eventScoreAfterLastFinishedRound)
        sink.writeByte(lastFinishedRoundIndex)
    }
}