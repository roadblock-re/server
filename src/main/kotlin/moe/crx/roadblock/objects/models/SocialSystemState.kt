package moe.crx.roadblock.objects.models

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class SocialSystemState : RObject {

    var allowReceivingFriendRequests: Boolean = false

    override fun read(sink: InputSink) {
        allowReceivingFriendRequests = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeBoolean(allowReceivingFriendRequests)
    }
}