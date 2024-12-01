package moe.crx.roadblock.updates.miscellaneous

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class MiscellaneousClaimedSystemNotificationRewardChanged : RObject {

    var hasClaimed: Boolean = false

    override fun read(sink: InputSink) {
        hasClaimed = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeBoolean(hasClaimed)
    }
}