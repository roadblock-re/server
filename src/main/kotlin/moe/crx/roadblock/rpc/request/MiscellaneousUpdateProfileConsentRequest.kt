package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.rpc.base.RequestPacket

class MiscellaneousUpdateProfileConsentRequest : RequestPacket() {

    var hasUserConsent: Boolean = false
    var source: Int = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        hasUserConsent = sink.readBoolean()
        source = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeBoolean(hasUserConsent)
        sink.writeInt(source)
    }
}