package moe.crx.roadblock.rpc.response

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.OnlineUserData
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

class GetOnlineUserInfoResponse : UpdatesQueueWithRootReactionsResponse() {

    var userData: OnlineUserData = OnlineUserData()

    override fun read(sink: InputSink) {
        super.read(sink)
        userData = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeObject(userData)
    }
}