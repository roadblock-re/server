package moe.crx.roadblock.updates.championship

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.ChampionshipRewardsTierId

class ChampionshipSystemClaimRankReward : RObject {

    var eventId: CalendarEventId = ""
    var rewardsTierId: ChampionshipRewardsTierId = 0
    var rewardIdx: Byte = 0

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        rewardsTierId = sink.readInt()
        rewardIdx = sink.readByte()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeInt(rewardsTierId)
        sink.writeByte(rewardIdx)
    }
}