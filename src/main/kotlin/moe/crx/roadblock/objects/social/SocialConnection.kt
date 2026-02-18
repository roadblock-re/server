package moe.crx.roadblock.objects.social

import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.OnlineUserData

class SocialConnection : RObject {

    var onlineUserData: OnlineUserData = OnlineUserData()

    override fun read(sink: InputSink) {
        onlineUserData = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(onlineUserData)
    }
}