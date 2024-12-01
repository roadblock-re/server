package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.Credentials
import moe.crx.roadblock.rpc.base.RequestPacket

class GetOnlineUserInfoRequest : RequestPacket() {

    var credentials: Credentials = Credentials()

    override fun read(sink: InputSink) {
        super.read(sink)
        credentials = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeObject(credentials)
    }
}