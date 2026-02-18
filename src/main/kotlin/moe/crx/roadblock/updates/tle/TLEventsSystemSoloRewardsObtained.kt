package moe.crx.roadblock.updates.tle

import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.tle.RewardBoosts
import moe.crx.roadblock.objects.tle.TLEventId

class TLEventsSystemSoloRewardsObtained : RObject {

    var calendarEventId: TLEventId = TLEventId()
    var rewardCountPerRaceConditionIdx: ByteArray = ByteArray(0)
    var rewardBoosts: RewardBoosts = RewardBoosts()
    var fromAutoclaim: Boolean = false

    override fun read(sink: InputSink) {
        calendarEventId = sink.readObject()
        rewardCountPerRaceConditionIdx = sink.readByteArray()
        rewardBoosts = sink.readObject()
        fromAutoclaim = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(calendarEventId)
        sink.writeByteArray(rewardCountPerRaceConditionIdx)
        sink.writeObject(rewardBoosts)
        sink.writeBoolean(fromAutoclaim)
    }
}