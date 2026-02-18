package moe.crx.roadblock.updates.championship

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.ChampionshipGroupId
import moe.crx.roadblock.objects.game.ChampionshipRewardsTierId

class ChampionshipSystemFinalsGroupChanged : RObject {

    var eventId: CalendarEventId = ""
    var groupId: ChampionshipGroupId = 0
    var rewardsTierId: ChampionshipRewardsTierId = 0

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        groupId = sink.readInt()
        rewardsTierId = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeInt(groupId)
        sink.writeInt(rewardsTierId)
    }
}