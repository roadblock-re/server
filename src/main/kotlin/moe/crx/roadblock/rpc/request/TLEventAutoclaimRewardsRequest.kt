package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.tle.TLEventId
import moe.crx.roadblock.rpc.base.RequestPacket

class TLEventAutoclaimRewardsRequest : RequestPacket() {

    var tlEventId: TLEventId = TLEventId()

    override fun read(sink: InputSink) {
        super.read(sink)
        tlEventId = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeObject(tlEventId)
    }
}