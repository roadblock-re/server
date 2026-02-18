package moe.crx.roadblock.updates.championship

import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.championship.ChampionshipStageType
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.ChampionshipRoundId

class ChampionshipSystemPracticeRewardsObtained : RObject {

    var eventId: CalendarEventId = ""
    var stageType: ChampionshipStageType = ChampionshipStageType.Qualifying
    var roundId: ChampionshipRoundId = 0
    var obtainedRewardIndices: ByteArray = ByteArray(0)
    var rewardCount: Int = 0

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        stageType = sink.readEnum()
        roundId = sink.readInt()
        obtainedRewardIndices = sink.readByteArray()
        rewardCount = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeEnum(stageType)
        sink.writeInt(roundId)
        sink.writeByteArray(obtainedRewardIndices)
        sink.writeInt(rewardCount)
    }
}